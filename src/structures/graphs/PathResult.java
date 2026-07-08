package structures.graphs;


import structures.node.Node;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.HashSet;

public class PathResult<T> {
    
    private final HashSet<Node<T>> visitados;
    private final LinkedHashSet<Node<T>> path;
    public Set<Node<T>> getVisitados() {
        return visitados;
    }
    public Set<Node<T>> getPath() {
        return path;
    }
    public PathResult(HashSet<Node<T>> visitados, LinkedHashSet<Node<T>> path) {
        this.visitados = visitados;
        this.path = path;
    }
    @Override
public String toString() {
    return "PathResult [visitados=" + visitados
            + ", path=" + (!path.isEmpty() ? path : "No se encontro un camino")
            + "]";
}

    

}
