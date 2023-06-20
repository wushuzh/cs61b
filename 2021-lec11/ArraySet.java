public class ArraySet<T> {

    private int size;
    private T[] items;

    public ArraySet() {
        size = 0;
        items = (T[]) new Object[42];
    }

    public boolean contains(T item) {
        for(int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public void add(T item) {
        if (!contains(item)) {
            items[size++] = item;
        }

    }

    public int size() {
        return size;
    }


    public static void main(String[] args) {
        ArraySet<String> as = new ArraySet<>();
        as.add("one");
        as.add("two");
        as.add("three");
        System.out.println("Set size is " + as.size);
        as.add("two");
        System.out.println("Set size is still " + as.size);

        System.out.println("Set contains 4 ? " + as.contains("four"));
        System.out.println("Set contains 1 ? " + as.contains("one"));

    }
}
