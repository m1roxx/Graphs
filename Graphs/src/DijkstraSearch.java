import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<V, Double> distTo;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        this.edgeTo = new HashMap<>();
        this.marked = new HashSet<>();
        this.distTo = new HashMap<>();
        for (V v : graph.getVertices().keySet()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        distTo.put(source, 0.0);
        dijkstra(graph, source);
    }

    private void dijkstra(WeightedGraph<V> graph, V source) {
        PriorityQueue<Map.Entry<V, Double>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(source, 0.0));

        while (!pq.isEmpty()) {
            V v = pq.poll().getKey();
            marked.add(v);
            for (Map.Entry<Vertex<V>, Double> entry : graph.getVertex(v).getAdjacencyVertices().entrySet()) {
                V w = entry.getKey().getData();
                double weight = entry.getValue();
                if (distTo.get(v) + weight < distTo.get(w)) {
                    distTo.put(w, distTo.get(v) + weight);
                    edgeTo.put(w, v);
                    pq.add(new AbstractMap.SimpleEntry<>(w, distTo.get(w)));
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(V v) {
        return distTo.get(v) < Double.POSITIVE_INFINITY;
    }

    @Override
    public List<V> pathTo(V v) {
        if (!hasPathTo(v)) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V x = v; x != null; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        return path;
    }
}
