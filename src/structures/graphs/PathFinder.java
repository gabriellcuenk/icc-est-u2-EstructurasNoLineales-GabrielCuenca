package structures.graphs;

import structures.graphs.PathResult;
// No contiene logica interna
// define los metodos
// no se puede instanciar

public interface PathFinder<T> {
    PathResult<T> find(Graph<T> graph, T start, T end);
}
