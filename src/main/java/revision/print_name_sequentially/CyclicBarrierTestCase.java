package revision.print_name_sequentially;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTestCase {
    public static void main(String[] args) {
        String[] words = {"I","am","Sourav"};
        CyclicBarrier barrier = new CyclicBarrier(words.length);
        Object lock = new Object();

        for(int i = 0; i<words.length; i++){
            final int turn = i;
            new Thread(() -> {
               try {
                   barrier.await();
               } catch (InterruptedException | BrokenBarrierException e) {
                   Thread.currentThread().interrupt();
               }
               synchronized(lock){
                   while(WordState.current != turn) {
                       try {
                           lock.wait();
                       } catch (InterruptedException e) {
                           Thread.currentThread().interrupt();
                       }
                   }
                   System.out.print(words[turn]+" ");
                   WordState.current++;
                   lock.notifyAll();
               }
            }).start();
        }
    }

    static class WordState{
        static int current = 0;
    }
}
