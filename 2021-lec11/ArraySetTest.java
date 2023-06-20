import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArraySetTest {
    @Test
    public void addNullIntoSet() {
        ArraySet<String> as = new ArraySet<>();
        as.add(null);
        as.add("one");

    }
}
