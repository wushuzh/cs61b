import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AListTest {
    @Test
    public void testEmptySize() {
        AList L = new AList();
        assertEquals(0, L.size());
    }

    @Test
    public void testAddAndSize() {
        AList L = new AList();
        L.addLast(9);
        L.addLast(8);
        assertEquals(2, L.size());
    }

    @Test
    public void testAndGetLast() {
        AList L = new AList();
        L.addLast(9);
        assertEquals(9, L.getLast());
        L.addLast(8);
        L.addLast(7);
        assertEquals(7, L.getLast());
    }

    @Test
    public void testGet() {
        AList L = new AList();
        L.addLast(9);
        assertEquals(9, L.get(0));
        L.addLast(8);
        L.addLast(7);
        assertEquals(7, L.get(2));
        assertEquals(8, L.get(1));
        assertEquals(9, L.get(0));
    }

    @Test
    public void testRemove() {
        AList L = new AList();
        L.addLast(9);
        assertEquals(9, L.removeLast());
        assertEquals(0, L.size());

        L.addLast(9);
        L.addLast(8);
        L.addLast(7);
        assertEquals(7, L.removeLast());
        assertEquals(8, L.removeLast());
        assertEquals(1, L.size());
        assertEquals(9, L.get(0));
    }

    @Test
    public void AddAndResizeArray() {
        AList L = new AList();
        for(int i = 0; i < 20; i++) {
            L.addLast(i);
            assertEquals(i, L.getLast());
            assertEquals(i+1, L.size());
        }
    }

    @Test
    public void addManyNumbersTest() {
        AList L = new AList();
        for(int i = 0; i < 100_0000; i++) {
            L.addLast(i);
        }

        for(int i = 99_9999; i >= 0; i--) {
            assertEquals(i, L.removeLast());
            assertEquals(i, L.size());
        }
    }
}
