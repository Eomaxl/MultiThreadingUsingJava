package session5.taskScheduler;

import lombok.SneakyThrows;

public class AdditionConsumer implements IConsumer{
    private boolean state = true;

    @SneakyThrows
    @Override
    public void consume(CalculationMessage message){
        state = false;
        System.out.println(Thread.currentThread().getName()+" : Addition started : "+message.toString());
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName()+" : Addition completed : "+(message.num1 + message.num2));
        state = true;
    }

    @Override
    public boolean isFree(){
        return this.state;
    }

}
