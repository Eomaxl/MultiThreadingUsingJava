package session6.diningPhilosopher;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class DiningPhilosopher implements Runnable {
    List<Fork> forks;
    Integer index;

    public void runv1(){
        Fork leftFork = forks.get((index - 1 + 5) % 5);
        Fork rightFork = forks.get((index + 1) % 5);

        // Lock interface
        while(true) {
            if(leftFork.isAvailable() && rightFork.isAvailable()) {
                synchronized (leftFork){
                    leftFork.markUnavailable();
                    if (rightFork.isAvailable()){
                        synchronized (rightFork){
                            if(leftFork.isAvailable() && rightFork.isAvailable()){
                                leftFork.markUnavailable();
                                rightFork.markUnavailable();
                                eat();
                            }
                        }
                    }
                }

                synchronized (new ForkWrapper(leftFork, rightFork)){
                    leftFork.markUnavailable();
                    rightFork.markUnavailable();
                    eat();
                }
            } else {
                think();
            }
        }
    }

    @Override
    @SneakyThrows
    public void run(){
        Fork leftFork = forks.get((index - 1 + 5) % 5);
        Fork rightFork = forks.get((index) % 5);

        while(true) {
            think();
            leftFork.getLock().lock();
            try {
                if(rightFork.getLock().tryLock(100, TimeUnit.MILLISECONDS)){
                    try {
                        eat();
                    } finally {
                        rightFork.getLock().unlock();
                    }
                }
            } finally {
                leftFork.getLock().unlock();
            }
        }
    }

    @SneakyThrows
    public void think(){
        System.out.println("Philosopher "+index+" thinking");
        Thread.sleep(5000);
        System.out.println("Philosopher "+index+" finished thinking");
    }

    @SneakyThrows
    public void eat(){
        System.out.println("Philosopher "+index+" is eating");
        Thread.sleep(2000);
        System.out.println("Philosopher "+index+" has finished eating");
    }
}
