package stack.and.queue;

import java.util.Iterator;

public class Queue<Item> implements Iterable{
    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private class Node<Item> {
        Item item;
        Node next;

        public Node(Item item){
            this.item = item;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(Item item){
        n++;
        Node oldLast = last;
        last = new Node(item);
        if(isEmpty()) first = last;
        else oldLast.next = last;
    }

    public Item dequeue(){
        if(isEmpty()) return null;
        n--;
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        return item;
    }

    public int size(){
        return n;
    }

    @Override
    public Iterator iterator() {
        return new ListIterator<>(first);
    }

    public class ListIterator<Item> implements Iterator<Item>{

        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext(){
            return current != null;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
