package session4.sqs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class SqsQueue {

    private List<IConsumer> consumerList = new ArrayList<>();
    final SqsState state = new SqsState(new ArrayList<>(), 0);
    final Queue<CalculationMessage> queue = new LinkedList<CalculationMessage>();

    public void registerConsumer(IConsumer consumer) {
        System.out.println("Registering consumer: " + consumer);
        consumerList.add(consumer);
        new Thread(new ConsumerWorker(state, consumer)).start();
    }

    public void publish(CalculationMessage message){
        synchronized (state) {
            state.q.add(message);
            state.notifyAll();
        }
    }

    public void resetOffset(int newOffset){
        synchronized (state) {
            if (newOffset > state.q.size()){
                throw new RuntimeException("Invalid offset");
            }
            System.out.println("Reseting to: " + newOffset);
            state.offset = newOffset;
            state.notifyAll();
        }
    }
}


/**
 * if check is not thread safe. We are not using queue.
 * Message is lost if no consumer is free. Rather consumer gets free, should pick it.
 *
 * We are not using queue.
 * We should parallelize the consumers.
 * */