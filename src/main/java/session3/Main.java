package session3;

import session3.BlockingQueue.MyBoundedBlockingQueueRunner;
import session3.OddEvenPrinter.EvenOddRunner;
import session3.SeriesPrinter.SeriesPrinterRunner;

public class Main {
    public static void main(String[] args){
        System.out.println("EvenOdd Printer Runner");
        EvenOddRunner evenOddRunner = new EvenOddRunner();
        evenOddRunner.run();
        System.out.println("Series Printer Runner");
        SeriesPrinterRunner seriesPrinterRunner = new SeriesPrinterRunner();
        seriesPrinterRunner.run();
    }
}

