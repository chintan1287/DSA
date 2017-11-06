package unionfind;

public class QuickUnion {
    private int[] id;
    private int n;

    public QuickUnion(int n) {
        this.n = n;
        id = new int[n];
        for(int i = 0; i< n; i++)
            id[i] = i;
    }

    private int root(int i){
        while (id[i]!=i) i = id[i];
        return i;
    }

    public boolean isConnected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int pId = root(p);
        int qId = root(q);
        id[pId] = qId;
    }
}
