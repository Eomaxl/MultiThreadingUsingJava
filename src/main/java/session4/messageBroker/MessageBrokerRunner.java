package session4.messageBroker;

import session4.sqs.AdditionConsumer;
import session4.sqs.CalculationMessage;
import session4.sqs.MinusConsumer;

import java.util.List;

public class MessageBrokerRunner {

    public static void run() throws InterruptedException {
        final MessageBroker messageBroker = new MessageBroker();

        messageBroker.register("add", List.of(new AdditionConsumer()));
        messageBroker.register("sub",List.of(new MinusConsumer(), new MinusConsumer()));

        messageBroker.publish("add",new CalculationMessage(1,2));
        messageBroker.publish("add",new CalculationMessage(3,4));
        messageBroker.publish("sub",new CalculationMessage(15,6));
        messageBroker.publish("sub",new CalculationMessage(25,6));
        messageBroker.publish("sub",new CalculationMessage(35,6));
        messageBroker.publish("sub",new CalculationMessage(45,6));
        messageBroker.publish("sub",new CalculationMessage(55,6));
        messageBroker.publish("sub",new CalculationMessage(65,6));
        messageBroker.publish("add",new CalculationMessage(47,8));
        messageBroker.publish("add",new CalculationMessage(77,8));
        messageBroker.publish("add",new CalculationMessage(57,8));
        messageBroker.publish("sub",new CalculationMessage(59,10));
        messageBroker.publish("sub",new CalculationMessage(49,10));
        messageBroker.publish("sub",new CalculationMessage(97,10));

        Thread.sleep(5000);
        messageBroker.register("add", List.of(new AdditionConsumer()));
        Thread.sleep(5000);

        messageBroker.resetOffset("sub",1);
    }
}
