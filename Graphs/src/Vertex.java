import java.util.*;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacencyVertices; // with weights

    public Vertex(V data) {
        this.data = data;
        this.adjacencyVertices = new HashMap<>();
    }

    public V getData() {
        return data;
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacencyVertices.put(destination, weight);
    }

    public Map<Vertex<V>, Double> getAdjacencyVertices() {
        return adjacencyVertices;
    }
}
