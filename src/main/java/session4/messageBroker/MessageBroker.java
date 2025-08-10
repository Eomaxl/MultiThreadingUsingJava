package session4.messageBroker;

import session4.sqs.CalculationMessage;
import session4.sqs.IConsumer;
import session4.sqs.SqsQueue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageBroker {
    private Map<String, SqsQueue> queues = new HashMap<String, SqsQueue>();

    public void register(String subscriptionName, List<IConsumer> consumers) {
        queues.putIfAbsent(subscriptionName, new SqsQueue());
        final SqsQueue sqsQueue = queues.get(subscriptionName);
        consumers.forEach(sqsQueue::registerConsumer);
    }

    public void publish(String consumerType, CalculationMessage message){
        if(queues.containsKey(consumerType)){
            queues.get(consumerType).publish(message);

        }
//        for(SqsQueue q: queues.values()){
//            q.publish(message);
//        }
    }

    public void resetOffset(String subName, int newOffset){
        queues.get(subName).resetOffset(newOffset);
    }
}
