package session5.taskScheduler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Task {

    private CalculationMessage message;
    private Long millisEpoch;
    private Long intervalMillis;
}
