package deque;

public class ArrayDeque<T> {

    private final int INITCAPACITY = 8;
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[INITCAPACITY];
        size = 0;
        nextFirst = INITCAPACITY / 2 ;
        nextLast = nextFirst + 1;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(T item) {
        size++;
        items[nextLast] = item;

        // calc the next valid index
        nextLast = calcRightDex(nextLast);

        // check if the size is beyond capacity, expand it
        if (nextLast == nextFirst) {
            doubleArray(items.length * 2);
            nextLast = nextFirst + 1 + size;
        }

    }

    /* calc the index on the right side */
    private int calcRightDex(int index) {
        index++;
        return (index + items.length) % items.length;
    }

    private void doubleArray(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        // copy the elements on the right side of nextFirst
        System.arraycopy(items, nextFirst + 1, newArray, nextFirst + 1, items.length - 1 - nextFirst);
        // copy the elements on the left side of nextFirst
        System.arraycopy(items, 0, newArray, items.length, nextLast);
        items = newArray;
    }

    public void addFirst(T item) {
        size++;
        items[nextFirst] = item;

        //calc the next valid First pos
        nextFirst = calcLeftDex(nextFirst);
        if (nextFirst == nextLast) {
            doubleArray(items.length * 2);
            nextLast = nextFirst + 1 + size;
        }

    }

    /** calc the index the left element */
    private int calcLeftDex(int index) {
        index--;
        return (index + items.length) % items.length;
    }
}
