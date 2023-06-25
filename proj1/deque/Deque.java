package deque;

public interface Deque<T> {

    /* error 1: Don't use redundant 'public' modifier. */
    void addFirst(T item);
    void addLast(T item);
    default boolean isEmpty() {
        return size() == 0;
    };
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);

}
