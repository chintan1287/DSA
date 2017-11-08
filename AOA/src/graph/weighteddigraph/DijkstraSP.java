package graph.weighteddigraph;

import graph.weightedgraph.EdgeWeightedGraph;

import java.util.*;

public class DijkstraSP {
    private WeightedDirectedEdge[] edgeTo;
    private double[] distTo;
    private Map<Integer, Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s){
        this.edgeTo = new WeightedDirectedEdge[G.V()];
        this.distTo = new double[G.V()];
        pq = new HashMap<Integer, Double>();

        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;

        distTo[s] = 0.0;

        pq.put(s, 0.0);

        while (pq.size()!= 0) {
            int v = (int)pq.keySet().toArray()[0];
            pq.remove(v);
            for(WeightedDirectedEdge e : G.adj(v)){
                relax(e);
            }
            pq = sortByValue(pq);
        }
    }

    private void relax(WeightedDirectedEdge e){
        int v = e.from();
        int w = e.to();

        if(distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            pq.put(w, distTo[w]);
        }
    }

    public Map sortByValue(Map unsortedMap) {
        Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }

    public double distTo(int v){
        return distTo[v];
    }

    public Iterable<WeightedDirectedEdge> edgeTo(int v){
        Stack<WeightedDirectedEdge> path = new Stack<>();
        for(WeightedDirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]){
            path.push(e);
        }
        return path;
    }

    public double weight(int v){
        double result = 0.0;

        for(WeightedDirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]){
            result += e.weight();
        }
        return result;
    }

    class ValueComparator implements Comparator {
        Map map;

        public ValueComparator(Map map) {
            this.map = map;
        }

        public int compare(Object keyA, Object keyB) {
            Comparable valueA = (Comparable) map.get(keyA);
            Comparable valueB = (Comparable) map.get(keyB);
            return valueB.compareTo(valueA);
        }
    }
}
