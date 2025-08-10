package session3.OddEvenPrinter;

public class EvenOddRunner {
    public static void run(){
        EvenOddState evenOddState = new EvenOddState(EvenOddTurn.ODD);
        EvenPrinter evenPrinter = new EvenPrinter(10, evenOddState);
        OddPrinter oddPrinter = new OddPrinter(10, evenOddState);

        new Thread(oddPrinter).start();
        new Thread(evenPrinter).start();

    }
}
