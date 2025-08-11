package session5.taskScheduler;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.PriorityQueue;

@AllArgsConstructor
public class ConsumerWorker implements Runnable{
    final PriorityQueue<Task> q;
    final IConsumer consumer;

    @SneakyThrows
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " , consumer started");
        while(true){
            Task firstElement;
            synchronized (q){
                while(true){
                    while(q.isEmpty()){
                        System.out.println(Thread.currentThread().getName() + " , No element in queue. Going to wait.");
                        q.wait();
                    }
                    firstElement = q.peek();
                    System.out.println(Thread.currentThread().getName() + " : " + firstElement.getMessage() +" , picked");
                    Long millisToWait = firstElement.getMillisEpoch() - System.currentTimeMillis();
                    System.out.println(Thread.currentThread().getName() + " : "+firstElement.getMessage()+", " + millisToWait + " milliseconds");
                    if (millisToWait > 0){
                        System.out.println(Thread.currentThread().getName() + ": " + firstElement.getMessage() + ", Going to wait as ");
                        q.wait(millisToWait); // We need notification when the time is elapsed
                        System.out.println(Thread.currentThread().getName() + ": " + firstElement.getMessage() + ", came out of wait");
                    } else {
                        if (firstElement.getIntervalMillis() != -1) {
                            q.add(new Task(firstElement.getMessage(), firstElement.getMillisEpoch() + firstElement.getIntervalMillis(), firstElement.getIntervalMillis()));
                            notifyAll();
                        }
                        break;
                    }
                }
                q.poll();
            }
            System.out.println(Thread.currentThread().getName() + ": " + firstElement.getMessage() + ", consuming");
            consumer.consume(firstElement.getMessage());
        }
    }

    @SneakyThrows
    public void runV1() {
        synchronized (q) {
            Task firstElement;
            while (true) {
                firstElement = q.peek();
                Long millisToWait = System.currentTimeMillis() - firstElement.getMillisEpoch();
                if (millisToWait > 0) {
                    q.wait(millisToWait); // We need notification when the time is elapsed
                } else {
                    break;
                }
            }
            q.poll();
            consumer.consume(firstElement.getMessage());

        }
    }

}
