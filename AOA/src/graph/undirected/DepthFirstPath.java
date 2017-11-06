package graph.undirected;

public class DepthFirstPath {
    private int s;
    private boolean[] marked;
    private int[] edgeTo;

    public DepthFirstPath(Graph G, int s){
        this.s = s;
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];

    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for(int w : G.adj(v)){
            if(!marked[w]) {
                marked[w] = true;
                dfs(G,w);
                edgeTo[w] = v;
            }
        }
    }

    public boolean hasPathTo(int w){
        return marked[w];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for(int w = v; w!=s; w=edgeTo[w]){
            stack.push(w);
        }
        stack.push(s);
        return stack;
    }
}
