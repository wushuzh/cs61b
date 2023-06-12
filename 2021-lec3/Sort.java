public class Sort {

    public static String[] sort(String[] x) {
        // find the smallest entry from the array
        // swap it with front entry
        // Selection sort the rest
        return x;
    }

    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    public static int findSmallest(String[] x) {
        int smallestIdx = 0;

        for(int i = 0; i < x.length; i++) {
            if (x[i].compareTo(x[smallestIdx]) < 0) {
                smallestIdx = i;
            }
        }
        return smallestIdx;
    }
}
