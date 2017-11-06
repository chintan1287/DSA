package unionfind;

public class QuickFind {

    private int[] id;
    private int n;

    public QuickFind(int n) {
        this.n = n;
        id = new int[n];
        for(int i = 0; i< n; i++)
            id[i] = i;
    }

    public boolean isConnected(int p, int q){
        return id[p] == id[q];
    }

    public void union(int p, int q){
        int pId = id[p];
        int qId = id[q];
        for(int i =0; i<n; i++){
            if(id[i]==pId)
                id[i] = qId;
        }
    }
}
