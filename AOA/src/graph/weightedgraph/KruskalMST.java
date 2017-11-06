package graph.weightedgraph;

import stack.and.queue.MinPQ;
import stack.and.queue.Queue;
import unionfind.QuickUnion;

import java.util.Iterator;

public class KruskalMST {

    private Queue<Edge> mst = new Queue<>();

    public KruskalMST(EdgeWeightedGraph G) {
        MinPQ<Edge> pq = new MinPQ<>(G.E());

        for (Edge edge : G.edges())
            pq.insert(edge);

        QuickUnion uf = new QuickUnion(G.V());

            while (!pq.isEmpty() && mst.size() < G.V() -1) {
                Edge edge = pq.deleteMin();
                int v = edge.either(); int w = edge.other(v);
                if(!uf.isConnected(v, w)) {
                    uf.union(v,w);
                    mst.enqueue(edge);
                }
            }
    }

    public Iterable<Edge> edges(){return mst;}

}
