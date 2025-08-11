package session5.taskScheduler;

public class MyScheduler {

    public void scheduleAfter(CalculationMessage message, int millisAfter){
        scheduleAtTime(message, System.currentTimeMillis() + millisAfter);
    }

    public void scheduleAtTime(CalculationMessage message, long millisSinceEpoch){

    }
}
