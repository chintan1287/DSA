package graph.weightedgraph;

import stack.and.queue.Queue;

import java.util.LinkedList;

public class EdgeWeightedGraph {

    private int v;
    private int e;
    private LinkedList<Edge>[] adj;
    private Queue<Edge> edges;

    public EdgeWeightedGraph(int v){
        this.v = v;
        this.e = 0;
        this.edges = new Queue<>();

        this.adj = new LinkedList[v];
        for (int i = 0; i< v; i++)
            adj[i] = new LinkedList<Edge>();
    }

    public void addEdge(Edge edge){
        this.e++;
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        edges.enqueue(edge);
    }

    public int V(){return this.v;}

    public int E(){return this.e;}

    public Iterable<Edge> adj(int v){return adj[v];}

    public Iterable<Edge> edges(){return edges;}

}
