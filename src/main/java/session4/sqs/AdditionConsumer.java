package session4.sqs;

import lombok.SneakyThrows;

public class AdditionConsumer implements IConsumer {
    private boolean isFree = true;

    @SneakyThrows
    @Override
    public void consume(CalculationMessage msg){
        isFree  = false;
        Thread.sleep(5000);
        System.out.println("Addition : "+ (msg.num1 + msg.num2));
        isFree = true;
    }

    @Override
    public boolean isFree(){
        return isFree;
    }
}
