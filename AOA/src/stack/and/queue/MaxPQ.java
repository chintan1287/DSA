package stack.and.queue;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int n;

    public MaxPQ(int n){
        pq = (Key[]) new Comparable[n+1];
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void insert(Key key){
        pq[++n] = key;
        swim(n);
    }

    public Key deleteMax(){
        Key key = pq[1];
        exch(1,n);
        n--;
        pq[n+1] = null;
        sink(1);
        return key;
    }

    // when child becomes greater than parent
    private void swim(int k){
        while (k>1 && less(k/2, k)) {
            exch(k/2,k);
            k = k/2;
        }
    }

    // When parent becomes smaller than child
    private void sink(int k){
        while (2*k<=n){
            int j = 2*k;
            if(j+1<=n && less(j,j+1)) j =j+1;
            if(less(k,j)){
                exch(k,j);
                k = j;
            }
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
