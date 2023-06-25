package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        for (int N = 1000; N <= 12_8000; N+=N) {
            SLList<Integer> sllist = new SLList<>();
            for (int i = 0; i < N; i++) {
                sllist.addLast(i);
            }

            int getLastOps = 1_0000;
            Ns.addLast(N);
            opCounts.addLast(getLastOps);
            Stopwatch sw = new Stopwatch();
            for (int M = 0; M < getLastOps; M++) {
                sllist.getLast();
            }
            times.addLast(sw.elapsedTime());
        }

        printTimingTable(Ns, times, opCounts);
    }

    /**
     *            N     time (s)        # ops  microsec/op
     * ------------------------------------------------------------
     *         1000         0.03        10000         3.40
     *         2000         0.07        10000         6.70
     *         4000         0.12        10000        12.10
     *         8000         0.25        10000        25.40
     *        16000         0.57        10000        57.20
     *        32000         0.93        10000        92.60
     *        64000         2.32        10000       231.50
     *       128000         6.52        10000       651.50
     */

}
