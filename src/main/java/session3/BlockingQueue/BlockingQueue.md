### Implement a bounded queue with the following operations:

- enqueue(value) : Add a value to the queue. If the queue is full, wait until there is space available.
- dequeue(): remove and return the front element from the queue. If the queue is empty, wait untill there is an element available.
- size() :Return the current size of the queue. The goal is to design a thread-safe, bounded blocking queue that ensures proper synchronization and efficient use of resources.

### Requirements:
- The queue has a maximum capacity 'capacity' specified during the initialization.
- The enqueue operation should block if the queue is full, and it should resume when space resume when an element becomes available.
- Ensure thread safety to prevent race conditions and maintain the integrity of the queue.
