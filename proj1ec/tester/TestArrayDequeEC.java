package tester;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

import static junit.framework.TestCase.assertEquals;

public class TestArrayDequeEC {

    @Test
    public void testDequeMethodsRandomly() {
        StudentArrayDeque<Integer> studentAD = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solutionAD = new ArrayDequeSolution<>();

        StringBuilder sb = new StringBuilder();
        int N = 5000;
        for (int i = 0; i < N; i++) {
            int operationChoose = StdRandom.uniform(0, 7);
            if (operationChoose == 0) {
                // addFirst
                int randInt = StdRandom.uniform(0, 100);
                studentAD.addFirst(randInt);
                solutionAD.addFirst(randInt);
                sb.append("addFirst(" + randInt + ")\n");
            } else if (operationChoose == 1) {
                // addLast
                int randInt = StdRandom.uniform(0, 100);
                studentAD.addLast(randInt);
                solutionAD.addLast(randInt);
                sb.append("addLast(" + randInt + ")\n");
            } else if (operationChoose == 2) {
                // isEmpty
                boolean expectedBool = solutionAD.isEmpty();
                boolean actualBool = studentAD.isEmpty();
                sb.append("isEmpty()\n");
                assertEquals(sb.toString(), expectedBool, actualBool);
            } else if (operationChoose == 3) {
                // size
                int expectedSize = solutionAD.size();
                int actualSize = studentAD.size();
                sb.append("size()\n");
                assertEquals(sb.toString(), expectedSize, actualSize);
            } else if (operationChoose == 4 && solutionAD.size() > 0) {
                // removeFirst
                Integer expectFirstInt = solutionAD.removeFirst();
                Integer studentFirstInt = studentAD.removeFirst();
                sb.append("removeFirst()\n");
                assertEquals(sb.toString(), expectFirstInt, studentFirstInt);
            } else if (operationChoose == 5 && solutionAD.size() > 0) {
                // removeLast
                Integer expectLastInt = solutionAD.removeLast();
                Integer studentLastInt = studentAD.removeLast();
                sb.append("removeLast()\n");
                assertEquals(sb.toString(), expectLastInt, studentLastInt);
            } else if (operationChoose == 6 && solutionAD.size() > 0) {
                // get(i)
                int totalSize = solutionAD.size();
                int validDex = StdRandom.uniform(0, totalSize);
                Integer expectGetInt = solutionAD.get(validDex);
                Integer studentGetInt = studentAD.get(validDex);
                sb.append("get(" + validDex + ")\n");
                assertEquals(sb.toString(), expectGetInt, studentGetInt);
            }
        }
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestArrayDequeEC.class);
    }
}
