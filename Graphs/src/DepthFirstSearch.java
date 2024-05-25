import java.util.*;

public class DepthFirstSearch<V> extends Search<V> {

    public DepthFirstSearch(MyGraph<V> graph, V source) {
        super(source);
        this.edgeTo = new HashMap<>();
        this.marked = new HashSet<>();
        dfs(graph, source);
    }

    private void dfs(MyGraph<V> graph, V v) {
        marked.add(v);
        for (V w : graph.getAdjacencyList().getOrDefault(v, new HashSet<>())) {
            if (!marked.contains(w)) {
                edgeTo.put(w, v);
                dfs(graph, w);
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

