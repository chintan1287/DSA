package graph.weighteddigraph;

import stack.and.queue.Queue;

import java.util.LinkedList;

public class EdgeWeightedDigraph {
    private int v;
    private int e;
    private LinkedList<WeightedDirectedEdge>[] adj;
    private Queue<WeightedDirectedEdge> edges;

    public EdgeWeightedDigraph(int v){
        this.v = v;
        this.e = 0;
        this.edges = new Queue<>();

        this.adj = new LinkedList[v];
        for (int i = 0; i< v; i++)
            adj[i] = new LinkedList<WeightedDirectedEdge>();
    }

    public void addEdge(WeightedDirectedEdge edge){
        this.e++;
        int v = edge.from();
        int w = edge.to();
        adj[v].add(edge);
        edges.enqueue(edge);
    }

    public int V(){return this.v;}

    public int E(){return this.e;}

    public Iterable<WeightedDirectedEdge> adj(int v){return adj[v];}

    public Iterable<WeightedDirectedEdge> edges(){return edges;}
}
