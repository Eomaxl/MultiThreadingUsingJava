package session3.SeriesPrinter;

public class SeriesPrinterRunner {
    public static void run(){
        SeriesPrinterState seriesPrinterState = new SeriesPrinterState(SeriesTurnName.ODD);
        final SeriesPrinter oddObj = new SeriesPrinter(1, 10, 2, seriesPrinterState, SeriesTurnName.ODD, SeriesTurnName.EVEN);
        final SeriesPrinter evenObj = new SeriesPrinter(2,10, 2, seriesPrinterState, SeriesTurnName.EVEN, SeriesTurnName.ODD);

        new Thread(oddObj).start();
        new Thread(evenObj).start();
    }
}
