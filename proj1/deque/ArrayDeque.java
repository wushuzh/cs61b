package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {

    private final int INITCAPACITY = 8;
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[INITCAPACITY];
        size = 0;
        nextFirst = INITCAPACITY / 2;
        nextLast = nextFirst + 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addLast(T item) {
        size++;
        items[nextLast] = item;

        /* calc the next valid index */
        nextLast = calcRightDex(nextLast);

        /* check if the size is beyond capacity, expand it */
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
        /* copy the elements on the right side of nextFirst */
        System.arraycopy(items, nextFirst + 1,
                newArray, nextFirst + 1,
                items.length - 1 - nextFirst);
        /* copy the elements on the left side of nextFirst */
        System.arraycopy(items, 0, newArray, items.length, nextLast);
        items = newArray;
    }

    @Override
    public void addFirst(T item) {
        size++;
        items[nextFirst] = item;

        /* calc the next valid First pos */
        nextFirst = calcLeftDex(nextFirst, items.length);
        if (nextFirst == nextLast) {
            doubleArray(items.length * 2);
            nextLast = nextFirst + 1 + size;
        }

    }

    /** calc the index the left element */
    private int calcLeftDex(int index, int length) {
        index--;
        return (index + length) % length;
    }

    @Override
    public T removeLast() {
        /* error 1: check if there is any elements existing */
        if (size == 0) {
            return null;
        }

        size--;
        int lastItemDex = calcLeftDex(nextLast, items.length);
        T item = items[lastItemDex];
        items[lastItemDex] = null;
        /* error 1: remember to reset the nextLast */
        nextLast = lastItemDex;

        /* error 1: for too small size, don't need to shrink */
        if (items.length >= 16 && size < items.length / 4) {
            /* error 1: the target size should be half of array, not half of deque size */
            shrinkArray(items.length / 2);
        }
        return item;
    }

    private void shrinkArray(int newSize) {
        T[] smallArray = (T[]) new Object[newSize];
        int oldArrayDex = calcRightDex(nextFirst);

        int i = newSize * 3 / 8;
        /* error 1: forget to reset nextFirst */
        /* error 1: calc nextFirst based on left pos of i */
        nextFirst = calcLeftDex(i, newSize);

        /* error 1: copy until next invalid pos */
        while (oldArrayDex != nextLast) {
            smallArray[i] = items[oldArrayDex];
            oldArrayDex = calcRightDex(oldArrayDex);
            i++;
        }
        /* error 1: reset nextLast; */
        nextLast = i;
        /* error 1: use smaller array */
        items = smallArray;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        int firstItemDex = calcRightDex(nextFirst);
        T firstItem = items[firstItemDex];
        items[firstItemDex] = null;
        nextFirst = firstItemDex;

        /* shrink if necessary */
        /* error 1: always use items.length for actually array */
        if (items.length >= 16 && size < items.length / 4) {
            shrinkArray(items.length / 2);
        }

        return firstItem;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int itemDex = calcRightDex(nextFirst + index);
        return items[itemDex];
    }

    @Override
    public void printDeque() {

        int firstItemDex = calcRightDex(nextFirst);

        /* error 1: loop until next invalid element */
        while (firstItemDex != nextLast) {
            System.out.print(items[firstItemDex] + " ");
            firstItemDex = calcRightDex(firstItemDex);
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        int pos = calcRightDex(nextFirst);

        @Override
        public boolean hasNext() {
            return pos != nextLast;
        }

        @Override
        public T next() {
            T returnItem = items[pos];
            pos = calcRightDex(pos);
            return returnItem;
        }
    }

    /* Returns whether or not the parameter o is equal to the Deque.
      o is considered equal
      if it is a Deque and if it contains the same contents
          (as goverened by the generic T’s equals method) in the same order.
      (ADDED 2/12: You’ll need to use the instance of keywords for this.
      Read https://www.javatpoint.com/downcasting-with-instanceof-operator
      for more information)
      */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        /* cast Object to Deque based on requirement */
        if (o instanceof Deque otherDeque) {
            if (otherDeque.size() != this.size) return false;
            for(int i = 0; i < size; i++) {
                /* use Generic T equals to test content is same or not */
                if (!get(i).equals(otherDeque.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean equalsInOldWay(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }

        /* cast Object to Deque based on requirement */
        Deque<T> otherDeque = (Deque<T>) o;
        if (otherDeque.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!otherDeque.get(i).equals(get(i))) {
                return false;
            }
        }
        return true;
    }
}
