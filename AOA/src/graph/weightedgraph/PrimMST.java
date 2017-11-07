package graph.weightedgraph;

import stack.and.queue.MinPQ;
import stack.and.queue.Queue;

public class PrimMST {
    private Queue<Edge> mst = new Queue<>();
    private boolean[] marked;
    private MinPQ<Edge> pq;

    public PrimMST(EdgeWeightedGraph G){
        this.marked = new boolean[G.V()];
        this.pq = new MinPQ<>(G.E());

        visit(G, 0);

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.deleteMin();
            int v = e.either(); int w = e.other(v);
            if(marked[v] && marked[w]) continue;
            mst.enqueue(e);
            if(!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v){
        marked[v] = true;
        for(Edge e : G.adj(v)) {
            if(!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    public Iterable<Edge> edges(){return mst;}
}
