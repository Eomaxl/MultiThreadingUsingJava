package session3.BlockingQueue;

import lombok.SneakyThrows;

import java.util.ArrayList;

public class MyBoundedBlockingQueueRunner {
    public static void run(){
        final MyBlockingQueue myBlockingQueue = new MyBlockingQueue(4, new ArrayList<>());
        new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run(){
                myBlockingQueue.enqueue(10);
                myBlockingQueue.enqueue(20);
                myBlockingQueue.enqueue(30);
                myBlockingQueue.enqueue(40);
                Thread.sleep(5000);
                myBlockingQueue.enqueue(50);
            }
        }).start();

        new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run(){
                System.out.println("Dequeued : "+myBlockingQueue.dequeue());
                Thread.sleep(5000);
                System.out.println("Dequeued : "+myBlockingQueue.dequeue());
                Thread.sleep(5000);
                System.out.println("Dequeued : "+myBlockingQueue.dequeue());
                Thread.sleep(5000);
                System.out.println("Dequeued : "+myBlockingQueue.dequeue());
                System.out.println("Dequeued : "+myBlockingQueue.dequeue());
                System.out.println("Dequeued : "+myBlockingQueue.dequeue());
                System.out.println("Dequeued : "+myBlockingQueue.dequeue());
            }
        }).start();
    }
}
