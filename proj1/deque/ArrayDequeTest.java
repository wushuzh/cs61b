package deque;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

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
}
