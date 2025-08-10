package session3.OddEvenPrinter;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;


@AllArgsConstructor
public class EvenPrinter implements Runnable{
    private int counter;
    private EvenOddState state;


    @SneakyThrows
    @Override
    public void run() {
        int currentNum = 2;
        while (currentNum <= counter) {
            synchronized (state){
                while (state.getEvenOddTurn() != EvenOddTurn.EVEN){
                    state.wait();
                }
                System.out.println(currentNum);
                currentNum += 2;
                state.setEvenOddTurn(EvenOddTurn.ODD);
                state.notifyAll();
            }
        }
    }
}
