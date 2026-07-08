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
    public PathResult<T> find(Graph<T> graph, T current, T end ){
        HashSet<Node<T>> visited = new HashSet<>();
        LinkedHashSet<Node<T>> path = new LinkedHashSet<>();

        boolean encontrado = dfs(graph, current, end, visited, path);

        if(!encontrado){
            path.clear();
        }

        return new PathResult<>(visited, path);
    }

    private boolean dfs(Graph<T> graph,
        T current, T end,
        Set<Node<T>> visited,
        Set<Node<T>> path){

            // caso base

            Node<T> nC = new Node<T>(current);
            Node<T> nE = new Node<T>(end);

            visited.add(nC);
            path.add(nC);
            if(nC.equals(nE)){
                return true;
            }

            for(Node<T> vecino : graph.getVecino(current)){
                if(!visited.contains(vecino)){
                    boolean encon = dfs(graph, vecino.getValue(), end, visited, path);
                    if(encon){
                        return true;
                    }
                }
            }

            path.remove(current);

            return false;
        }
}
