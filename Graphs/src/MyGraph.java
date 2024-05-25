import java.util.*;

public class MyGraph<V> {
    private final boolean directed;
    private final Map<V, Set<V>> adjacencyList;

    public MyGraph(boolean directed) {
        this.directed = directed;
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(V source, V destination) {
        adjacencyList.computeIfAbsent(source, k -> new HashSet<>()).add(destination);
        if (!directed) {
            adjacencyList.computeIfAbsent(destination, k -> new HashSet<>()).add(source);
        }
    }

    public Map<V, Set<V>> getAdjacencyList() {
        return adjacencyList;
    }
}
