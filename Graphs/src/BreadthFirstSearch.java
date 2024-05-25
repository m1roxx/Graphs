import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(MyGraph<V> graph, V source) {
        super(source);
        this.edgeTo = new HashMap<>();
        this.marked = new HashSet<>();
        bfs(graph, source);
    }

    private void bfs(MyGraph<V> graph, V source) {
        Queue<V> queue = new LinkedList<>();
        queue.add(source);
        marked.add(source);
        while (!queue.isEmpty()) {
            V v = queue.poll();
            for (V w : graph.getAdjacencyList().getOrDefault(v, new HashSet<>())) {
                if (!marked.contains(w)) {
                    edgeTo.put(w, v);
                    marked.add(w);
                    queue.add(w);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(V v) {
        return marked.contains(v);
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
