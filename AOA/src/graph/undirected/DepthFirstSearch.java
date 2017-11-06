package graph.undirected;

public class DepthFirstSearch {

    private int s;
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s){
        this.s = s;
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public int count(){
        return count;
    }

    public boolean marked(int w){
        return marked[w];
    }
}
