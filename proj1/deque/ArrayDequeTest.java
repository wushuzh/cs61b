package deque;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertTrue;

public class ArrayDequeTest {

    @Test
    public void testEqualsWithWrongOrderLinkedListDequeAndArrayDeque() {
        LinkedListDeque<String> lld = new LinkedListDeque<>();
        ArrayDeque<String> ad = new ArrayDeque<>();

        // two, three, one
        lld.addLast("one");
        lld.addLast("two");
        lld.addLast("three");

        // one, two, three
        ad.addLast(new String("one"));
        ad.addLast(new String("three"));
        ad.addLast(new String("two"));

        assertFalse(lld.equals(ad));
        assertFalse(ad.equals(lld));
/*        assertFalse(lld.equalsInNewWay(ad));
        assertFalse(ad.equalsInNewWay(lld));*/
    }

    @Test
    public void testEqualWithThreeElement() {
        ArrayDeque<String> ad = new ArrayDeque<>();

        ad.addFirst("one");
        ad.addLast("two");
        ad.addLast("three");

        ArrayDeque<String> ad2 = new ArrayDeque<>();
        ad2.addFirst(new String("one"));
        ad2.addLast(new String("two"));
        ad2.addLast(new String("three"));

        assertTrue(ad.equals(ad2));
        /*assertTrue(ad.equalsInNewWay(ad2));*/
    }

    @Test
    public void testEqualWithDiffOrder() {
        ArrayDeque<String> ad = new ArrayDeque<>();

        ad.addFirst("one");
        ad.addLast("two");
        ad.addLast("three");

        ArrayDeque<String> ad2 = new ArrayDeque<>();
        ad2.addFirst(new String("one"));
        ad2.addLast(new String("three"));
        ad2.addLast(new String("two"));

        assertFalse(ad.equals(ad2));
        /*assertFalse(ad.equalsInNewWay(ad2));*/
    }

    @Test
    public void testEqualWithDiffSize() {
        ArrayDeque<String> ad = new ArrayDeque<>();

        ad.addFirst("one");
        ad.addLast("two");

        ArrayDeque<String> ad2 = new ArrayDeque<>();
        ad2.addFirst("one");
        ad2.addLast("two");
        ad2.addLast("three");

        assertFalse(ad.equals(ad2));
        /*assertFalse(ad.equalsInNewWay(ad2));*/
    }

    @Test
    public void testIteratorWithAlmostFullElements() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        for(int i = 0; i < 14; i++) {
            ad.addLast(i);
        }

        // error 1: do not use  assertEquals in the forloop to validate iterable
        // since default hasNext and next will not enter into loop in the first place
        List<Integer> intsFirstToLast = new ArrayList<>();
        for(int x : ad) {
            intsFirstToLast.add(x);
        }
        assertEquals(14, intsFirstToLast.size());

        for(int i = 0; i < 14; i++) {
            assertEquals(i, (int) intsFirstToLast.get(i));
        }
    }

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
