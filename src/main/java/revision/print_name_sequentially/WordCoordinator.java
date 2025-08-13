package revision.print_name_sequentially;

public class WordCoordinator {
    private int turn = 0;
    private final Object lock = new Object();

    public void printWord(String word, int myTurn){
            synchronized (lock){
                try {
                    if (turn != myTurn) {
                        lock.wait();
                    }
                } catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                System.out.print(word+" ");
                turn++;
                lock.notifyAll();
            }
    }

    public static void main(String[] args){
        WordCoordinator wordCoordinator = new WordCoordinator();
        Thread thread1 = new Thread(() -> wordCoordinator.printWord("I", 0));
        Thread thread2 = new Thread(() -> wordCoordinator.printWord("am", 1));
        Thread thread3 = new Thread(() -> wordCoordinator.printWord("sourav", 2));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
