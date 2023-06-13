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

    /** Returns an IntList identical to L, but with all values incremented by x.
     *  Valuse in L cannot change !
     *  */
    public static IntList incrList(IntList L, int x) {
        if (L != null) {
            return new IntList(L.first + x, incrList(L.rest, x));
        }
        return null;
    }

    public static IntList iterativeIncrList(IntList L, int x) {
        if (L == null) {
            return null;
        }


        IntList newL = new IntList(L.first + x, null);

        IntList p = newL;
        IntList orignialL = L.rest;

        while (orignialL != null) {
            p.rest = new IntList( orignialL.first + x, null);
            p = p.rest;
            orignialL = orignialL.rest;
        }

        return newL;

    }

    /** Returns an IntList identical to L, but with all values incremented by x.
     * Not allowed to use 'new' (to save memory
     * */
    public static IntList dincrList(IntList L, int x) {
        if (L == null) {
            return null;
        }
        L.first += x;
        L.rest = dincrList(L.rest, x);

        return L;
    }

    public static IntList iterativeDincrList(IntList L, int x) {
        IntList p = L;
        while (p != null){
            p.first += x;
            p = p.rest;
        }
        return L;
    }

    public static void main(String[] args) {
        IntList L1 = new IntList(15, null);
        L1 = new IntList(10, L1);
        L1 = new IntList(5, L1);

        System.out.println(L1.size());
        System.out.println(L1.iterativeSize());

        System.out.println("IncrList by 5:");
        IntList L1plus5 = incrList(L1, 5);
        System.out.println(L1plus5.get(0));
        System.out.println(L1plus5.get(1));
        System.out.println(L1plus5.get(2));

        System.out.println(L1.get(0));
        System.out.println(L1.get(1));
        System.out.println(L1.get(2));

        System.out.println("iterative version of incrList by 10:");
        IntList L1plus10 = iterativeIncrList(L1, 10);
        System.out.println(L1plus10.get(0));
        System.out.println(L1plus10.get(1));
        System.out.println(L1plus10.get(2));

        System.out.println(L1.iterativeGet(0));
        System.out.println(L1.iterativeGet(1));
        System.out.println(L1.iterativeGet(2));

        System.out.println("dIncrList by 5:");
        IntList L2plus5 = dincrList(L1, 5);
        System.out.println(L2plus5.get(0));
        System.out.println(L2plus5.get(1));
        System.out.println(L2plus5.get(2));

        System.out.println(L1.iterativeGet(0));
        System.out.println(L1.iterativeGet(1));
        System.out.println(L1.iterativeGet(2));

        System.out.println("iterative version of dIncrList by 5:");
        IntList L3plus5 = iterativeDincrList(L1, 5);
        System.out.println(L3plus5.get(0));
        System.out.println(L3plus5.get(1));
        System.out.println(L3plus5.get(2));

        System.out.println(L1.iterativeGet(0));
        System.out.println(L1.iterativeGet(1));
        System.out.println(L1.iterativeGet(2));
    }
}
