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
}
