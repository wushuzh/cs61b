/** Array based list.
 *  @author Josh Hug
 */

//         0 1  2 3 4 5
// items: [6 9 -1 0 0 0 ...]
// size: 3
public class AList<T> {

    private T[] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = (T[]) new Object[10];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size++] = x;
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return items[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        if ((size / items.length) < 1/4) resize(items.length/2);
        T lastItem = getLast();
        items[size - 1] = null;
        size = size - 1;
        return lastItem;
    }
}