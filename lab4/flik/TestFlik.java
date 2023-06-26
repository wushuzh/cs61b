package flik;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TestFlik {

    private int[] testNums = {42, 128};
    @Test
    public void testIsSameNumberCreatingByValueOf() {
        for (int i: testNums) {
            Integer expectInteger = Integer.valueOf(i);
            Integer actualInteger = Integer.valueOf(i);

            assertTrue(Flik.isSameNumber(expectInteger, actualInteger));
        }
    }

    @Test
    public void testWithPrimitiveNumbers() {
        for (int i: testNums) {
            assertTrue(Flik.isSameNumber(i, i));
        }
    }

    @Test
    public void testWithMaxPrimitiveNumAndWrapperInteger() {
        for (int i: testNums) {
             assertTrue(Flik.isSameNumber(i, Integer.valueOf(i)));
        }
    }
}
