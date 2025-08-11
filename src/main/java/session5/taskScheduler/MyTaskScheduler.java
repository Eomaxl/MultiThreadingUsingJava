package session5.taskScheduler;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MyTaskScheduler {
    private List<IConsumer> consumers = new ArrayList<>();
    private PriorityQueue<Task> q = new PriorityQueue<>(Comparator.comparing(Task::getMillisEpoch));

    public void scheduleAfter(CalculationMessage message, int millisAfter, long intervalMillis){
        scheduleAtTime(message, System.currentTimeMillis() + millisAfter, intervalMillis);
    }

    public void registerConsumer(IConsumer consumer){
        consumers.add(consumer);
        new Thread(new ConsumerWorker(q, consumer)).start();
    }

    @SneakyThrows
    public void scheduleAtTime(CalculationMessage message, long millisSinceEpoch, long intervalMillis){
        synchronized (q) {
            q.add(new Task(message, millisSinceEpoch, intervalMillis));
            q.notifyAll();
        }
    }
}
