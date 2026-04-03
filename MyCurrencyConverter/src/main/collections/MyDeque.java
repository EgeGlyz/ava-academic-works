package my.collections;


import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A fixed-capacity, generic double-ended queue implemented as a ring buffer.
 * Supports add/remove at both ends in O(1) time and is Iterable<T>.
 */
public class MyDeque<T> implements Iterable<T> {
    private final T[] data;
    private final int capacity;
    private int front = 0;   // index of the first element
    private int size = 0;    // number of elements stored

    @SuppressWarnings("unchecked")
    public MyDeque(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be > 0");
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    /**
     * Returns the i-th element, where get(0) is the front.
     */
    public T get(int i) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException("Index " + i);
        int idx = (front + i) % capacity;
        return data[idx];
    }

    public void addFirst(T elem) {
        if (isFull())
            throw new IllegalStateException("Deque is full");
        front = (front - 1 + capacity) % capacity;
        data[front] = elem;
        size++;
    }

    public T getFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty");
        return data[front];
    }

    public T removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty");
        T elem = data[front];
        data[front] = null;      // help GC
        front = (front + 1) % capacity;
        size--;
        return elem;
    }

    public void addLast(T elem) {
        if (isFull())
            throw new IllegalStateException("Deque is full");
        int tail = (front + size) % capacity;
        data[tail] = elem;
        size++;
    }

    public T getLast() {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty");
        int tailIndex = (front + size - 1) % capacity;
        return data[tailIndex];
    }

    public T removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty");
        int tailIndex = (front + size - 1) % capacity;
        T elem = data[tailIndex];
        data[tailIndex] = null;  // help GC
        size--;
        return elem;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int cursor = 0;
            @Override
            public boolean hasNext() {
                return cursor < size;
            }
            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return get(cursor++);
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(get(i));
        }
        sb.append("]");
        return sb.toString();
    }
}
