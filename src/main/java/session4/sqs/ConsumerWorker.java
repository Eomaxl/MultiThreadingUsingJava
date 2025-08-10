package session4.sqs;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class ConsumerWorker implements Runnable {
    final SqsState state;
    final IConsumer consumer;

    @SneakyThrows
    @Override
    public void run() {
        while(true){
            final CalculationMessage msg;
            synchronized (state) {
                while(state.offset == state.q.size()){
                    state.wait();
                }
                msg = state.q.get(state.offset);
                state.offset++;
            }
            consumer.consume(msg);
        }
    }
}
