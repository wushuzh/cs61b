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

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public int getFirst() {
        return first.item;
    }

    public void addLast(int x) {

        IntNode p = first;

        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);

    }

    public int size(IntNode n) {
        if (n.next == null) {
            return 1;
        }
        return 1 + size(n.next);
    }
    public int size() {
        return size(first);
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
        SLList newL = null;
        System.out.println(newL);

        newL = new SLList(10);
        System.out.println(newL.first.item);
        System.out.println(newL.getFirst());

        newL.addFirst(9);
        System.out.println(newL.getFirst());

        newL.addLast(11);
        System.out.println(newL);
        System.out.println("The total size of SLList is "+ newL.size());

    }
}
