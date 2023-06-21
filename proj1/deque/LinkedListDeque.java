package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T> {

    private Node sentFront;
    private Node sentBack;
    private int size;

    public class Node {
        public T item;
        public Node next;
        public Node prev;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public LinkedListDeque() {
        sentFront = new Node(null, null, null);
        sentBack = new Node(null, null, null);
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
        size = 0;
    }

    public boolean isEmpty() {
        return sentFront.next == sentBack;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        Node oldFirst = sentFront.next;
        Node newFirst = new Node(sentFront, item, oldFirst);
        sentFront.next = newFirst;
        oldFirst.prev = newFirst;

        size++;
    }

    public void addLast(T item) {
        Node oldLast = sentBack.prev;
        Node newLast = new Node(oldLast, item, sentBack);
        sentBack.prev = newLast;
        oldLast.next = newLast;
        size++;
    }

    public T removeFirst() {
        if (sentFront.next == sentBack) return null;

        Node oldFirst = sentFront.next;
        Node newFirst = oldFirst.next;

        sentFront.next = newFirst;
        newFirst.prev = sentFront;
        size--;

        return oldFirst.item;
    }

    public T removeLast() {
        if (sentFront.next == sentBack) return null;

        Node oldLast = sentBack.prev;
        Node newLast = oldLast.prev;

        newLast.next = sentBack;
        sentBack.prev = newLast;
        size--;

        return oldLast.item;
    }

    public T get(int index) {

        Node p = sentFront;
        while (p.next != sentBack) {
            if (index == 0) return p.next.item;
            p = p.next;
            index--;
        }
        return null;
    }

    public T getRecursive(int i) {
        if (i >= size || isEmpty()) return null;
        return getRecursive(this, i);
    }

    private T getRecursive(LinkedListDeque<T> lld, int i) {
        if (i == 0) return lld.sentFront.next.item;
        LinkedListDeque<T> lldOneLess = new LinkedListDeque<>();
        Node secondNode = lld.sentFront.next.next;

        lldOneLess.sentFront.next = secondNode;
        lldOneLess.sentBack = lld.sentBack;
        return getRecursive(lldOneLess, i-1);

    }

    public void printDeque() {
        String result = "";
        Node p = sentFront.next;
        while (p != sentBack) {
            result += p.item.toString() + " ";
            p = p.next;
        }
        System.out.println(result);
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {

        private Node pointerNode = sentFront.next;

        @Override
        public boolean hasNext() {
            return pointerNode != sentBack;
        }

        @Override
        public T next() {
            T returnItem = pointerNode.item;
            pointerNode = pointerNode.next;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof LinkedListDeque otherlld) {
            if (otherlld.size != size) return false;
            for(int i = 0; i < size; i++) {
                if(get(i) != otherlld.get(i)) return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListDeque<String> lld = new LinkedListDeque<>();
        lld.addFirst("one");
        lld.size();
        lld.printDeque();
    }

}
