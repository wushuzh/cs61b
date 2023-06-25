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

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyL = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyL.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int sizeL = L.size();
                int sizeBL = buggyL.size();
                assertEquals("The size check :", sizeL, sizeBL);
            } else if (operationNumber == 2 && L.size() > 0) {
                // getLast
                int returnL = L.getLast();
                int returnBL = buggyL.getLast();
                assertEquals("The getLast check : ", returnL, returnBL);
            } else if (operationNumber == 3 && L.size() > 0) {
                // removeLast
                int removeL = L.removeLast();
                int removeBL = buggyL.removeLast();
                assertEquals("The removeLast check: ", removeL, removeBL);
            }
        }
    }
}
