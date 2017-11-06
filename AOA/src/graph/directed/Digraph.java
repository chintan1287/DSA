package graph.directed;

import java.util.LinkedList;

public class Digraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private int v;
    private int e;
    private LinkedList<Integer>[] adj;

    public Digraph(int v){
        this.v = v;
        this.e = 0;
        this.adj = new LinkedList[v];
        for (int i = 0; i<v; i++)
            adj[i] = new LinkedList<>();
    }

    public int V(){
        return v;
    }

    public int E(){
        return e;
    }

    public void addEdge(int v, int w){
        e++;
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public Digraph reverse(){
        Digraph reverse = new Digraph(V());
        for(int v = 0; v < V(); v++){
            for(int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(v + " vertices, " + e + " edges " + NEWLINE);
        for (int vertex = 0; vertex < v; vertex++) {
            s.append(vertex + ": ");
            for (int w : adj[vertex]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
