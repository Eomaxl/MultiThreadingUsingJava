package session4.messageBroker;

import session4.sqs.AdditionConsumer;
import session4.sqs.CalculationMessage;
import session4.sqs.MinusConsumer;

import java.util.List;

public class MessageBrokerRunner {

    public static void run() throws InterruptedException {
        final MessageBroker messageBroker = new MessageBroker();

        messageBroker.register("add", List.of(new AdditionConsumer()));
        messageBroker.register("minus",List.of(new MinusConsumer(), new MinusConsumer()));

        messageBroker.publish(new CalculationMessage(1,2));
        messageBroker.publish(new CalculationMessage(3,4));
        messageBroker.publish(new CalculationMessage(5,6));
        messageBroker.publish(new CalculationMessage(7,8));
        messageBroker.publish(new CalculationMessage(9,10));

        Thread.sleep(5000);
        messageBroker.register("add", List.of(new AdditionConsumer()));
        Thread.sleep(5000);

        messageBroker.resetOffset("minus",1);
    }
}
