package binarytrees;

import stack.and.queue.Queue;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private int count;
        private Node left, right;
        public Node(Key key, Value value, int count){
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value){
        if(x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left,key,value);
        else if(cmp>0) x.right = put(x.right, key, value);
        else x.value = value;
        x.count = 1+ size(x.left) +size(x.right);
        return x;
    }

    private int size(Node x){
        if(x==null) return 0;
        return x.count;
    }

    public int size(){
        return size(root);
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

    public  void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if(x == null) return null;
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1+size(x.left)+size(x.right);
        return x;
    }

    public  void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp<0) x.left = delete(x.left, key);
        else if(cmp>0) x.right = delete(x.right, key);
        else{
            if(x.left == null) return x.right;
            if(x.right == null) return x.left;

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = 1+size(x.left)+size(x.right);
        return x;
    }

    private Node min(Node x){
        if(x == null) return null;
        while (x.left != null)
            x = x.left;
        return x;
    }

    public int rank(Key key){
        return rank(root, key);
    }

    private int rank(Node x, Key key){
        if(x==null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp<0) return rank(x.left, key);
        else if(cmp>0) return 1+size(x.left)+rank(x.right, key);
        else return size(x.left);
    }

    public Value floor(Key key){
        Node x = floor(root, key);
        if(x == null) return null;
        return x.value;
    }

    private Node floor(Node x, Key key){
        if(x == null) return null;

        int cmp = key.compareTo(x.key);

        if(cmp == 0) return x;
        else if(cmp < 0) return floor(x.left, key);
        else {
            Node t = floor(x.right, key);
            if(t!= null) return t;
            else return x;
        }
    }

    public Value ceil(Key key){
        Node x = ceil(root, key);
        if(x == null) return null;
        return x.value;
    }

    private Node ceil(Node x, Key key){
        if(x == null) return null;

        int cmp = key.compareTo(x.key);

        if(cmp == 0) return x;
        else if(cmp > 0) return ceil(x.right, key);
        else {
            Node t = ceil(x.left, key);
            if(t!= null) return t;
            else return x;
        }
    }

    public int height(){
        return height(root);
    }

    private int height(Node x){
        if(x==null) return 0;
        return 1+Math.max(height(x.left), height(x.right));
    }

    public int diameter(){
        return diameter(root);
    }

    private int diameter(Node x){
        if(x==null) return 0;
        int leftHeight = height(x.left);
        int rightHeight = height(x.right);
        return Math.max(1+leftHeight+rightHeight, Math.max(diameter(x.left), diameter(x.right)));
    }

    public void printInOrder(Node x){
        if(x != null){
            printInOrder(x.left);
            System.out.print(x.value + " ");
            printInOrder(x.right);
        }
    }

    public void printPreOrder(Node x){
        if(x != null){
            System.out.print(x.value + " ");
            printPreOrder(x.left);
            printPreOrder(x.right);
        }
    }

    public void printPostOrder(Node x){
        if(x != null){
            printPostOrder(x.left);
            printPostOrder(x.right);
            System.out.print(x.value + " ");
        }
    }

    public void printLevelOrder(){
        Node x = root;
        Queue<Node> queue = new Queue<>();
        queue.enqueue(x);
        while (!queue.isEmpty()){
            Node node = queue.dequeue();
            System.out.print(node.value + " ");
            if(node.left != null) queue.enqueue(node.left);
            if(node.right != null) queue.enqueue(node.right);
        }
    }

    public static void main(String[] args){
        BST<Character, Character> bst = new BST<>();
        bst.put('S', 'S');
        bst.put('E', 'E');
        bst.put('X', 'X');
        bst.put('A', 'A');
        bst.put('R', 'R');
        bst.put('C', 'C');
        bst.put('H', 'H');
        bst.put('M', 'M');
        System.out.print("InOrder: "); bst.printInOrder(bst.root); System.out.println();
        System.out.print("PreOrder: "); bst.printPreOrder(bst.root); System.out.println();
        System.out.print("PostOrder: "); bst.printPostOrder(bst.root); System.out.println();
        System.out.print("LevelOrder: ");bst.printLevelOrder(); System.out.println();
        System.out.println("Floor G: "+bst.floor('G'));
        System.out.println("Floor Q: "+bst.ceil('Q'));
        System.out.println("Size: "+bst.size());
        System.out.println("Height: "+bst.height());
        System.out.println("Diameter: "+bst.diameter());
    }
}
