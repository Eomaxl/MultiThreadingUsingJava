package session4.sqs;

import lombok.SneakyThrows;

public class MinusConsumer implements IConsumer{
    private boolean isFree = true;

    @SneakyThrows
    @Override
    public void consume(CalculationMessage msg) {
        isFree = false;
        System.out.println(Thread.currentThread().getName() + ": Minus started: " + msg.toString());
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + ": Minus completed: " + (msg.num1 - msg.num2));
        isFree = true;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }
}
