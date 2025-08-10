package session3.OddEvenPrinter;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class OddPrinter implements Runnable{
    private int maxNum;
    private EvenOddState state;


    @SneakyThrows
    @Override
    public void run(){
        int num = 1;
        while (num <= maxNum) {
            synchronized (state) {

                while (state.getEvenOddTurn() != EvenOddTurn.ODD) {
                    state.wait();
                }
                System.out.println(num);
                num += 2;
                state.setEvenOddTurn(EvenOddTurn.EVEN);
                state.notifyAll();
            }
        }
    }
}
