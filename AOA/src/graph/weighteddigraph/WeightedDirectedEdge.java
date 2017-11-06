package graph.weighteddigraph;

public class WeightedDirectedEdge implements Comparable<WeightedDirectedEdge>{

    private int v;
    private int w;
    private double weight;

    public WeightedDirectedEdge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from(){
        return v;
    }

    public int to() {
        return w;
    }

    public double weight(){return weight;}

    @Override
    public int compareTo(WeightedDirectedEdge that) {
        if(this.weight > that.weight) return 1;
        else if(this.weight < that.weight) return -1;
        else return 0;
    }

}
