package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> fixedList = new AListNoResizing<>();
        BuggyAList<Integer> buggyList = new BuggyAList<>();

        for (int i: new int[]{4, 5, 6}) {
            fixedList.addLast(i);
            buggyList.addLast(i);
        }

        for (int i = 3; i < 0; i++) {
            assertEquals(i, buggyList.size());
            assertEquals(fixedList.size(), buggyList.size());
            assertEquals(fixedList.removeLast(), buggyList.removeLast());
        }

    }
}
