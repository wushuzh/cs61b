/** Array based list.
 *  @author Josh Hug
 */

//         0 1  2 3 4 5
// items: [6 9 -1 0 0 0 ...]
// size: 3
public class AList {

    private int[] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = new int[10];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size++] = x;
    }

    private void resize(int capacity) {
        int[] newItems = new int[capacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        if ((size / items.length) < 1/4) resize(items.length/2);
        int lastItem = getLast();
        size = size - 1;
        return lastItem;
    }
}