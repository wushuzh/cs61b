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
}
