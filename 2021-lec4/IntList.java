public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + rest.size();
    }

    public int iterativeSize() {
        int count = 0;
        IntList p = this;
        while (p != null) {
            count++;
            p = p.rest;
        }
        return count;
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i-1);
    }

    public int iterativeGet(int i) {
        IntList p = this;
        while (i != 0) {
            p = p.rest;
            i--;
        }
        return p.first;
    }

    public static void main(String[] args) {
        IntList L1 = new IntList(15, null);
        L1 = new IntList(10, L1);
        L1 = new IntList(5, L1);

        System.out.println(L1.size());
        System.out.println(L1.iterativeSize());

        System.out.println(L1.get(0));
        System.out.println(L1.get(1));
        System.out.println(L1.get(2));

        System.out.println(L1.iterativeGet(0));
        System.out.println(L1.iterativeGet(1));
        System.out.println(L1.iterativeGet(2));
    }
}
