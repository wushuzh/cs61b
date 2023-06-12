import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestSort {

    public static void testSortWithoutJUnit() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);
        for(int i = 0; i < input.length; i++) {
            if (! input[i].equals(expected[i])) {
                System.out.println("Error: expected " + expected[i] + ", but get " + input[i] + " instead.");
                return;
            }
        }
    }

    public static void testSortWithJUnit() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);
        assertArrayEquals(expected, input);

    }


    public static void main(String[] args) {

        testSortWithoutJUnit();
        testSortWithJUnit();

    }
}
