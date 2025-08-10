package session4.sqs;

public class SqsQueueRunner {


    public static void run() {
        final SqsQueue queue = new SqsQueue();
        queue.registerConsumer(new AdditionConsumer());
        queue.registerConsumer(new AdditionConsumer());

        queue.publish(new CalculationMessage(1,2));
        queue.publish(new CalculationMessage(3,4));
        queue.publish(new CalculationMessage(5,6));
    }
}
