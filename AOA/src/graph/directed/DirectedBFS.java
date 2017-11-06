package graph.directed;

import stack.and.queue.Queue;

public class DirectedBFS {

    private boolean[] marked;

    public DirectedBFS(Digraph G, int s){
        this.marked = new boolean[G.V()];
        bfs(G, s);
    }

    private void bfs(Digraph G, int v){
        Queue<Integer> queue = new Queue<>();
        marked[v] = true;
        queue.enqueue(v);
        while (!queue.isEmpty()) {
            int w = queue.dequeue();
            for(int p : G.adj(w)) {
                if(!marked[p]) {
                    marked[p] = true;
                    queue.enqueue(p);
                }
            }
        }
    }

    public boolean visited(int v) {return marked[v];}
}
