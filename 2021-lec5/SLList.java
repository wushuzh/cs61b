public class SLList {

    public static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;
    private int size;


    public SLList() {
        first = null;
        size = 0;
    }

    public SLList(int x) {
        first = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
        size += 1;
    }

    public int getFirst() {
        return first.item;
    }

    public void addLast(int x) {

        size += 1;

        IntNode p = first;
        if (first == null) {
            first = new IntNode(x, null);
            return;
        }

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
        return recursiveSize(first);
    }

    public int size() {
        return size;
    }

    public String toString() {
        String resultStr = null;
        IntNode p = first;
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
        System.out.println(newL.first.item);
        System.out.println(newL.getFirst());

        newL.addFirst(9);
        System.out.println(newL.getFirst());

        newL.addLast(11);
        System.out.println(newL);
        System.out.println("Calc the total size of SLList on the fly: "+ newL.recursiveSize());
        System.out.println("Get the cached size of SLList is "+ newL.size());

    }
}
