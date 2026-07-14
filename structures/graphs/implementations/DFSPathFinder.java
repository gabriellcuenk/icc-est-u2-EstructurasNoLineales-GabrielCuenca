package structures.graphs.implementations;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.HashSet;

import structures.node.Node;
import structures.graphs.Graph;
import structures.graphs.PathFinder;
import structures.graphs.PathResult;

public class DFSPathFinder<T> implements PathFinder<T> {

    @Override
    public PathResult<T> find(Graph<T> graph, T current, T end) {

        Set<T> visited = new HashSet<>();
        Set<T> path = new LinkedHashSet<>();

        boolean encontrado = dfs(graph, current, end, visited, path);

        if (!encontrado) {
            path.clear();
        }

        return new PathResult<>(visited, path);
    }

    private boolean dfs(Graph<T> graph,
                        T current,
                        T end,
                        Set<T> visited,
                        Set<T> path) {

        visited.add(current);
        path.add(current);

        if (current.equals(end)) {
            return true;
        }

        for (Node<T> vecino : graph.getVecino(current)) {

            if (!visited.contains(vecino.getValue())) {

                if (dfs(graph, vecino.getValue(), end, visited, path)) {
                    return true;
                }

            }
        }

        path.remove(current);

        return false;
    }
}