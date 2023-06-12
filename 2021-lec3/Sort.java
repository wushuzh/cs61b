public class Sort {

    public static String[] sort(String[] x) {
        // find the smallest entry from the array
        // swap it with front entry
        // Selection sort the rest
        return x;
    }

    public static String findSmallest(String[] x) {

        String smallest = x[0];
        for(int i = 0; i < x.length; i++) {
            if (x[i].compareTo(smallest) < 0) {
                smallest = x[i];
            }
        }
        return smallest;
    }
}
