package deque;

import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class ArrayDequeTest {

    @Test
    public void testEmptyArrayDeque() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        assertEquals(0, ad.size());
    }

    @Test
    public void testAddLastAndSize() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i = 1; i <= 10; i++) {
            ad.addLast(i);
            assertEquals(i, ad.size());
        }
    }

    @Test
    public void testAddFirstAndSize() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i = 1; i <= 10; i++) {
            ad.addFirst(i);
            assertEquals(i, ad.size());
        }
    }

    @Test
    public void testRemoveLastAndSize() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i = 1; i <= 10; i++) {
            ad.addLast(i);
        }
        for(int i = 10; i > 0; i--) {
            int lastElement = ad.removeLast();
            assertEquals(i, lastElement);
        }

        assertNull(ad.removeLast());
        assertNull(ad.removeLast());
        assertNull(ad.removeLast());

    }

    @Test
    public void testRemoveFirstAndSize() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        assertNull(ad.removeFirst());

        for(int i = 1; i <= 10; i++) {
            ad.addLast(i);
            assertEquals(i, ad.size());
            // the first element is always 1 with only addLast
            assertEquals(1, (int) ad.get(0));
        }
        assertEquals(10, ad.size());

        for(int i = 1; i <= 10; i++) {
            int firstElement = ad.removeFirst();
            assertEquals(i, firstElement);
        }

        assertNull(ad.removeLast());
        assertNull(ad.removeLast());
        assertNull(ad.removeLast());
    }

    @Test
    public void testAddandGet() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        for(int i = 0; i < 9; i++) {
            ad.addLast(i);
        }

        assertEquals(0, (int) ad.get(0));

        ad.removeFirst();
        assertEquals(1, (int) ad.get(0));
        assertEquals(8, ad.size());

        ad.addFirst(42);
        assertEquals(42, (int) ad.get(0));
        assertEquals(8, (int) ad.get(8));
        assertEquals(9, ad.size());

        assertNull(ad.get(9));
        assertNull(ad.get(10));
        ad.printDeque();

    }
}
