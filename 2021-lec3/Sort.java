public class Sort {

    public static void sort(String[] x) {
        // find the smallest entry from the array
        // swap it with front entry
        // Selection sort the rest
        sort(x, 0);
    }

    public static void sort(String[] x, int fromIdx) {
        if (fromIdx == x.length) {
            return;
        }
        int smallIdx = findSmallest(x, fromIdx);
        swap(x, fromIdx, smallIdx);
        sort(x, fromIdx+1);

    }



    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    public static int findSmallest(String[] x, int fromIdx) {
        int smallestIdx = fromIdx;

        for(int i = fromIdx; i < x.length; i++) {
            if (x[i].compareTo(x[smallestIdx]) < 0) {
                smallestIdx = i;
            }
        }
        return smallestIdx;
    }
}
