package session5.taskScheduler;


import lombok.SneakyThrows;

public interface IConsumer {
    void consume(CalculationMessage message);

    boolean isFree();
}
