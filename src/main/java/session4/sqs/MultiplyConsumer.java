package session4.sqs;

import lombok.SneakyThrows;

public class MultiplyConsumer implements IConsumer {
    private boolean isFree = true;

    @SneakyThrows
    @Override
    public void consume(CalculationMessage msg){
        isFree = false;
        System.out.println(Thread.currentThread().getName() + ": Multiply started: " + msg.toString());
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName()+" Multiplication completed"+ (msg.num1 * msg.num2));
        isFree = true;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }
}
