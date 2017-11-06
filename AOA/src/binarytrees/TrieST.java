package binarytrees;

public class TrieST<Value> {

    private static final int R = 256;
    private Node root = new Node();

    private static class Node{
        private Object value;
        private Node[] next = new Node[R];
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d){
        if(x == null) x = new Node();
        if(d == key.length()) { x.value = val; return x;}
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }

    public Value get(String key){
        Node x = get(root, key, 0);
        if (x==null)
            return null;
        return (Value) x.value;
    }

    private Node get(Node x, String key, int d){
        if(x==null) return null;
        if(d == key.length()) { return x;}
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    public void delete(String key){
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d){
        if(x==null) return null;
        if(d == key.length()) x.value = null;
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }

        // handle subsequent deleted nodes
        for(int c = 0; c<R; c++){
            if(x.next[c]!=null) return x;
        }

        return null;
    }

}
