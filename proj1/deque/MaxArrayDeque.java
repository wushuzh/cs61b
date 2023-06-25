package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private Comparator<T> embeddedComparator;

    public MaxArrayDeque(Comparator<T> c) {
        embeddedComparator = c;
    }

    /** Returns the maximum element in the deque as governed by
     *  the given comparator from the constructor.
     *  If the MaxArrayDeque is empty, simply return null
     */
    public T max() {
        if (isEmpty()) {
            return null;
        }
        T maxItem = get(0);
        for (int i = 1; i < size(); i++) {
            int cmp = embeddedComparator.compare(get(i), maxItem);
            if (cmp > 0) {
                maxItem = get(i);
            }
        }
        return maxItem;
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T maxItem = get(0);
        for (int i = 1; i < size(); i++) {
            int cmp = c.compare(get(i), maxItem);
            if (cmp > 0) maxItem = get(i);
        }
        return maxItem;
    }
}
