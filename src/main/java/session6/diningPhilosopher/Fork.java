package session6.diningPhilosopher;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@RequiredArgsConstructor
public class Fork {
    @NonNull
    int index;
    private boolean available = true;
    private Lock lock = new ReentrantLock();

    public boolean isAvailable(){
        return available;
    }

    public void markUnavailable(){
        available = false;
    }

    public void markAvailable(){
        available = true;
    }
}
