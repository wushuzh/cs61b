import org.junit.Test;

import static org.junit.Assert.*;

public class ArraySetTest {
    @Test
    public void addNullIntoSetThrowIllegalArgumentException() {
        ArraySet<String> as = new ArraySet<>();
        try {
            as.add(null);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Cannot add null!");
        }
    }

    @Test
    public void testThreeEquals() {
        ArraySet<Integer> aset1 = new ArraySet<>();

        ArraySet<Integer> aset2 = new ArraySet<>();
        for (int i: new int[]{5, 23, 42}) {
            aset1.add(i);
            aset2.add(i);
        }

        assertTrue(aset1.equals(aset2));
    }

    @Test
    public void testEqualsWithDiffSize() {
        ArraySet<Integer> aset1 = new ArraySet<>();

        ArraySet<Integer> aset2 = new ArraySet<>();
        for (int i: new int[]{5, 23, 42}) {
            aset1.add(i);
        }

        aset1.add(77);

        assertFalse(aset1.equals(aset2));
        assertFalse(aset2.equals(aset1));
    }

    @Test
    public void testEqualsWithDiffElement() {
        ArraySet<Integer> aset1 = new ArraySet<>();

        ArraySet<Integer> aset2 = new ArraySet<>();
        for (int i: new int[]{5, 23}) {
            aset1.add(i);
        }

        aset1.add(42);
        aset2.add(44);

        assertFalse(aset1.equals(aset2));
    }

    @Test
    public void testEqualsWithDiffOrder() {
        ArraySet<Integer> aset1 = new ArraySet<>();
        ArraySet<Integer> aset2 = new ArraySet<>();

        aset1.add(5);
        aset1.add(23);
        aset1.add(42);

        aset2.add(23);
        aset2.add(5);
        aset2.add(42);

        assertTrue(aset1.equals(aset2));
    }
}
