package session3.SeriesPrinter;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class SeriesPrinter implements Runnable{
    private int start;
    private int end;
    private int inc;
    private SeriesPrinterState seriesPrinterState;
    private SeriesTurnName seriesTurnName;
    private SeriesTurnName nextSeriesTurnName;

    @SneakyThrows
    @Override
    public void run(){
        int current = start;
        while(current <=end){
            synchronized (seriesPrinterState){
                while(seriesPrinterState.getTurn() != seriesTurnName){
                    seriesPrinterState.wait();
                }
                System.out.println(current);
                current += inc;
                seriesPrinterState.setTurn(nextSeriesTurnName);
                seriesPrinterState.notifyAll();
            }
        }
    }
}
