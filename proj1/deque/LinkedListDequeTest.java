package deque;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();
    }

    @Test
    public void addFirstWithEmptyTest() {
        LinkedListDeque<String> lld1 = new LinkedListDeque<>();
        lld1.addFirst("one");

        assertEquals(1, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {

        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

    }

    @Test
    /* check index with value with a few due to performance with get */
    public void LLDequeGetTest() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();

        for(int i = 9; i >= 0; i--) {
            lld.addFirst(i);
        }

        assertEquals("The size of list should be 10", 10, lld.size());

        for(int i = 0; i < 20; i++) {
            if (i < 10) {
                assertEquals("Get the first half using iterative get method", i, (int) lld.get(i));
                assertEquals("Get the first half using iterative get method", i, (int) lld.getRecursive(i));
            } else {
                assertEquals("Get not exist index get null", null, lld.get(i));
                assertEquals("Get not exist index get null", null, lld.getRecursive(i));
            }
        }
    }


    @Test
    public void testIterableInterface() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        for (int i = 0; i < 20; i++) {
            lld.addLast(i);
        }

        List<Integer> intsList = new ArrayList<>();
        for(int item: lld) {
            intsList.add(item);
        }

        assertEquals(20, intsList.size());
        for(int i = 0; i < 20; i++) {
            assertEquals(i, (int) intsList.get(i));
        }
    }

    @Test
    public void testEqualsWithDiffSize() {
        LinkedListDeque<String> lld1 = new LinkedListDeque<>();
        LinkedListDeque<String> lld2 = new LinkedListDeque<>();

        lld1.addLast("two");
        lld1.addLast("three");

        lld2.addLast("two");
        lld2.addLast("three");
        lld2.addFirst("one");

        assertFalse(lld1.equals(lld2));
        assertFalse(lld2.equals(lld1));
    }

    @Test
    public void testEqualsWithThreeElements() {
        LinkedListDeque<String> lld1 = new LinkedListDeque<>();
        LinkedListDeque<String> lld2 = new LinkedListDeque<>();

        lld1.addLast("two");
        lld1.addLast("three");
        lld1.addFirst("one");

        lld2.addLast("two");
        lld2.addLast("three");
        lld2.addFirst("one");

        assertTrue(lld1.equals(lld2));
        assertTrue(lld2.equals(lld1));
    }

    @Test
    public void testEqualsWithSameSizeDiffOrder() {
        LinkedListDeque<String> lld1 = new LinkedListDeque<>();
        LinkedListDeque<String> lld2 = new LinkedListDeque<>();

        // two, three, one
        lld1.addLast("one");
        lld1.addLast("two");
        lld1.addLast("three");

        // one, two, three
        lld2.addLast("one");
        lld2.addLast("two");
        lld2.addLast("oneoneone");

        assertFalse(lld1.equals(lld2));
        assertFalse(lld2.equals(lld1));
    }
}
