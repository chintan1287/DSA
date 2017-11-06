package stack.and.queue;

public class Stack<Item> {

    private Node<Item> first;
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

    public void push(Item item){
        n++;
        Node oldFirst = first;
        first = new Node<>(item);
        first.next = oldFirst;
    }

    public Item pop(){
        if(isEmpty()) return null;
        n--;
        Item item = first.item;
        first = first.next;
        return item;
    }

    public Item peep(){
        if(isEmpty()) return null;
        Item item = first.item;
        return item;
    }

    public int size(){
        return n;
    }
}
