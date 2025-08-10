package session4.sqs;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SqsState {
    public final List<CalculationMessage> q;
    public Integer offset;
}
