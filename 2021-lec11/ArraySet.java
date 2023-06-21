import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArraySet<T> implements Iterable<T> {

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

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null!");
        }
        if (!contains(item)) {
            items[size++] = item;
        }

    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {

        private int pos;

        public ArraySetIterator() {
            pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < size;
        }

        @Override
        public T next() {
            return items[pos++];
        }
    }

    @Override
    public String toString() {
        StringBuilder returnSB = new StringBuilder("{");
        for(int i = 0; i < size - 1; i++) {
            returnSB.append(items[i].toString());
            returnSB.append(",");
        }
        returnSB.append(items[size-1]);
        returnSB.append("}");
        return returnSB.toString();
    }

    public String toStringSlow() {
        String resultString = "{";
        for(int i = 0; i < size; i++) {
            resultString += items[i].toString();
            if (i < size - 1) {
                resultString += ",";
            }
        }
        resultString += "}";
        return  resultString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof ArraySet otherArraySet) {
            if (size != otherArraySet.size) return false;
            // error 1: order of elements does not matter for SET
            for(T t: this) {
                if( !otherArraySet.contains(t)) return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArraySet<String> as = new ArraySet<>();
        as.add("one");
        as.add("two");
        as.add("three");

        System.out.println(as);

        System.out.println("Set size is " + as.size);
        as.add("two");
        System.out.println("Set size is still " + as.size);

        System.out.println("Set contains 4 ? " + as.contains("four"));
        System.out.println("Set contains 1 ? " + as.contains("one"));

        Iterator<String> aseer = as.iterator();

        while (aseer.hasNext()) {
            System.out.println(aseer.next());
        }

        for(String s: as) {
            System.out.println(s);
        }

        Set<Integer> javaset = new HashSet<>();
        javaset.add(1);
        javaset.add(2);
        javaset.add(3);

        Iterator<Integer> seer = javaset.iterator();
        while (seer.hasNext()) {
            System.out.println(seer.next());
        }

        for(Integer i : javaset) {
            System.out.println(i);
        }

    }
}
