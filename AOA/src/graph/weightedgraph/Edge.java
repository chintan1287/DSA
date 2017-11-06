package graph.weightedgraph;

public class Edge implements Comparable<Edge>{

    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either(){
        return v;
    }

    public int other(int v) {
        if(this.v == v) return this.w;
        return this.v;
    }

    public double weight(){return weight;}

    @Override
    public int compareTo(Edge that) {
        if(this.weight > that.weight) return 1;
        else if(this.weight < that.weight) return -1;
        else return 0;
    }
}
