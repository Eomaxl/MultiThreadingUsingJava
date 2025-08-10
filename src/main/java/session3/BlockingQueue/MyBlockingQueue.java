package session3.BlockingQueue;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;

@AllArgsConstructor
public class MyBlockingQueue {
    private int size;
    private List<Integer> items;

    @SneakyThrows
    public void enqueue(int item) {
        System.out.println("Enqueueing " + item);
        synchronized(this) {
            System.out.println("Got the lock for item " + item);
            while (items.size() >= size) {
                System.out.println("Waiting for item " + item);
                // make the thread waiting, and add the element to it. once the space is available
                wait();
                System.out.println("Got the lock for item " + item);
            }
            items.add(item);
            System.out.println("Add the item " + item+" and released the lock");
            notifyAll();
        }
    }

    @SneakyThrows
    public int dequeue() {
        synchronized(this) {
            while (items.isEmpty()){
                // make the thread wait, and give back the element , once it is available
                wait();
            }
            final Integer dequeueItem = items.remove(0);
            notifyAll();
            return dequeueItem;
        }
    }
}
