public class SLList {

    public static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;


    public SLList() {
        sentinel = new IntNode(42, null);
        size = 0;
    }

    public SLList(int x) {
        this();
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {

        size += 1;

        IntNode p = sentinel;

        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);

    }

    public int recursiveSize(IntNode n) {
        if (n == null) {
            return 0;
        }
        if (n.next == null) {
            return 1;
        }
        return 1 + recursiveSize(n.next);
    }
    public int recursiveSize() {
        return recursiveSize(sentinel.next);
    }

    public int size() {
        return size;
    }

    public String toString() {
        String resultStr = null;
        IntNode p = sentinel.next;
        while (p != null) {
            if (resultStr == null) {
                resultStr = String.valueOf(p.item);
            } else {
                resultStr += " -> " + p.item;
            }
            p = p.next;
        }
        return resultStr;
    }

    public static void main(String[] args) {
        //IntList oldL = new IntList(10, null);
        //System.out.println(oldL.first);
        SLList newL = new SLList();
        System.out.println(newL);
        System.out.println(newL.recursiveSize());

        newL.addLast(10);
        System.out.println(newL.getFirst());

        newL.addFirst(9);
        System.out.println(newL.getFirst());

        newL.addLast(11);
        System.out.println(newL);
        System.out.println("Calc the total size of SLList on the fly: "+ newL.recursiveSize());
        System.out.println("Get the cached size of SLList is "+ newL.size());

    }
}
