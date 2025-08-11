package session6.diningPhilosopher;

import java.util.ArrayList;
import java.util.List;

public class DiningPhilosopherRunner {
    public static void run(){
        final ArrayList<Fork> forks = new ArrayList<>();
        forks.add(new Fork(0));
        forks.add(new Fork(1));
        forks.add(new Fork(2));
        forks.add(new Fork(3));
        forks.add(new Fork(4));

        final List<DiningPhilosopher> diningPhilosophers = new ArrayList<>();
        diningPhilosophers.add(new DiningPhilosopher(forks, 0));
        diningPhilosophers.add(new DiningPhilosopher(forks, 1));
        diningPhilosophers.add(new DiningPhilosopher(forks, 2));
        diningPhilosophers.add(new DiningPhilosopher(forks, 3));
        diningPhilosophers.add(new DiningPhilosopher(forks, 4));

        for(DiningPhilosopher dp: diningPhilosophers){
            new Thread(dp).start();
        }
    }
}
