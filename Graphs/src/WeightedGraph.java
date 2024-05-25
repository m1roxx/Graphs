import java.util.*;

public class WeightedGraph<V> {
    private final boolean directed;
    private final Map<V, Vertex<V>> vertices;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
        this.vertices = new HashMap<>();
    }

    public void addEdge(V source, V destination, double weight) {
        Vertex<V> src = vertices.computeIfAbsent(source, Vertex::new);
        Vertex<V> dest = vertices.computeIfAbsent(destination, Vertex::new);

        src.addAdjacentVertex(dest, weight);
        if (!directed) {
            dest.addAdjacentVertex(src, weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }
}
