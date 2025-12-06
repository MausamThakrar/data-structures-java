import java.util.LinkedList;

public class Queue<T> {

    private final LinkedList<T> items = new LinkedList<>();

    public void enqueue(T item) {
        items.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("dequeue from empty queue");
        return items.removeFirst();
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("peek from empty queue");
        return items.getFirst();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return "Queue" + items.toString();
    }
}
