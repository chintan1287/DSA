package graph.directed;

public class DirectedDFS {

    private boolean[] marked;

    public DirectedDFS(Digraph G, int s){
        this.marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for(int w : G.adj(v)){
            if(!marked[v])
                dfs(G, w);
        }
    }

    public boolean visited(int v){
        return marked[v];
    }
}
