import java.util.*;

public abstract class Search<V> {
    protected Map<V, V> edgeTo;
    protected Set<V> marked;
    protected final V source;

    public Search(V source) {
        this.source = source;
    }

    public abstract boolean hasPathTo(V v);

    public abstract List<V> pathTo(V v);
}

