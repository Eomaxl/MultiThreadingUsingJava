package session4.sqs;

public interface IConsumer {

    public void consume(CalculationMessage calculationMessage);

    boolean isFree();
}
