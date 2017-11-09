package binarytrees;

public class RBT<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private int count;
        private boolean color;
        private Node left, right;
        public Node(Key key, Value value, int count, boolean color){
            this.key = key;
            this.value = value;
            this.count = count;
            this.color = color;
        }
    }

    public Value get(Key key){
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if(cmp < 0) x = x.left;
            else if(cmp>0) x = x.right;
            else return x.value;
        }
        return null;
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node h, Key key, Value value) {
        if(h == null) return new Node(key, value, 1, RED);
        int cmp = key.compareTo(h.key);
        if(cmp < 0 ) h.left = put(h.left, key, value);
        else if(cmp > 0 ) h.right = put(h.right, key, value);
        else h.value = value;

        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right)) flipColor(h);

        h.count = 1+size(h.left)+size(h.right);
        return h;
    }

    private int size(Node x){
        if(x==null) return 0;
        return x.count;
    }

    public int size(){
        return size(root);
    }

    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColor(Node x){
        x.color = RED;
        x.left.color = BLACK;
        x.right.color = BLACK;
    }

    private boolean isRed(Node x){
        if(x==null) return false;
        return x.color == RED;
    }

}
