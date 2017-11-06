package graph.undirected;

import stack.and.queue.Queue;

import java.util.Stack;

public class BreathFirstPaths {
    private int s;
    private boolean[] marked;
    private int[] edgeTo;

    public BreathFirstPaths(Graph G, int s){
        this.s = s;
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int v){
        marked[v] = true;
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(v);
        while (!queue.isEmpty()) {
            int w = queue.dequeue();
            for(int p : G.adj(w)) {
                if(!marked[p]) {
                    marked[p] = true;
                    queue.enqueue(p);
                    edgeTo[p] = w;
                }
            }
        }
    }

    public boolean hasPathTo(int w){
        return marked[w];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int w = v; w!=s; w = edgeTo[w])
            stack.push(w);
        stack.push(s);
        return stack;
    }
}
