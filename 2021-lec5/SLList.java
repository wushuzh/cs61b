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

    public static void main(String[] args) {
        //IntList oldL = new IntList(10, null);
        //System.out.println(oldL.first);

        SLList newL = new SLList(10);
        System.out.println(newL.first.item);
        System.out.println(newL.getFirst());

        newL.addFirst(9);
        System.out.println(newL.getFirst());
    }
}
