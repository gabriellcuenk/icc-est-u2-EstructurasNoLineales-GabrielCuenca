package structures.graphs.implementations;

import structures.graphs.Graph;
import structures.graphs.PathFinder;
import structures.graphs.PathResult;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import structures.node.Node;

public class BFSPathFinder<T> implements PathFinder<T> {

    @Override
    public PathResult<T> find(Graph<T> graph, T start, T end) {
        Queue<T> queue = new LinkedList<>();
        Set<T> visited = new LinkedHashSet<>();
        Map<Node<T>, Node<T>> parent = new LinkedHashMap<>();
        Set<T> visitados = new LinkedHashSet<>();
        queue.add(start);
        visitados.add(start);
        parent.put(new Node<T>(start), null);

        while(!queue.isEmpty()){
            T current = queue.poll();
            visited.add(current);
            if(current.equals(end)) {
                return new PathResult<T>(visited, buildPath(parent,end));
            }
            for(Node<T> vecino : graph.getVecino(current)){
                if(!visited.contains(vecino.getValue())){
                    queue.add(vecino.getValue());
                    visitados.add(vecino.getValue());
                    parent.put(vecino, new Node<>(current));
                }
            }
        }

        return new PathResult<T>(visited, new HashSet<>());
    }

    private Set<T> buildPath(Map<Node<T>, Node<T>> parent, T end) {
        Set<T> path = new LinkedHashSet<>();
        Node<T> nEnd = new Node<>(end);

        for(Node<T> at = nEnd; at != null; at = parent.get(at)) {
            path.add(at.getValue());
        }

        return path;
    }

}