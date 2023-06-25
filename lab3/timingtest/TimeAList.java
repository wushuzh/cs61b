package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {

        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        for (int N = 1000; N <= 12_8000; N += N) {
            Ns.addLast(N);
            opCounts.addLast(N);

            AList<Integer> targetList = new AList<>();
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < N; i++) {
                targetList.addLast(i);
            }
            double durationInSec = sw.elapsedTime();

            times.addLast(durationInSec);
        }
        printTimingTable(Ns, times, opCounts);
    }

    /** bad resize
     *            N     time (s)        # ops  microsec/op
     * ------------------------------------------------------------
     *         1000         0.00         1000         2.00
     *         2000         0.01         2000         4.50
     *         4000         0.01         4000         3.25
     *         8000         0.05         8000         6.75
     *        16000         0.16        16000         9.81
     *        32000         0.55        32000        17.19
     *        64000         1.81        64000        28.30
     *       128000         6.91       128000        54.01
     */

    /** good resize by factor 2
     *            N     time (s)        # ops  microsec/op
     * ------------------------------------------------------------
     *         1000         0.00         1000         1.00
     *         2000         0.00         2000         0.00
     *         4000         0.00         4000         0.25
     *         8000         0.00         8000         0.13
     *        16000         0.00        16000         0.06
     *        32000         0.01        32000         0.16
     *        64000         0.00        64000         0.06
     *       128000         0.01       128000         0.05
     *
     */

    /** by small factor 1.01
     *            N     time (s)        # ops  microsec/op
     * ------------------------------------------------------------
     *         1000         0.00         1000         3.00
     *         2000         0.00         2000         0.50
     *         4000         0.00         4000         0.50
     *         8000         0.01         8000         1.00
     *        16000         0.02        16000         1.38
     *        32000         0.01        32000         0.31
     *        64000         0.02        64000         0.34
     *       128000         0.05       128000         0.35
     */
}
