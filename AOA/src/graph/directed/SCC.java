package graph.directed;

public class SCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public SCC(Digraph G){
        this.marked = new boolean[G.V()];
        this.id = new int[G.V()];
        this.count = 0;
        DepthFirstOrder topological = new DepthFirstOrder(G.reverse());

        for (int v : topological.reversePost()) {
            if(!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        id[v] = count;
        for(int w : G.adj(v)){
            if(!marked[w]){
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }
}
