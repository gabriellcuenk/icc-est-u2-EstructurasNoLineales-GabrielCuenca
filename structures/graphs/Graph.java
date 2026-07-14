package structures.graphs;

import structures.node.Node;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class Graph<T> {

    private Map<Node<T>,Set<Node<T>>> graph;

    public Graph(){
        this.graph = new HashMap<Node<T>, Set<Node<T>>>();
    }

    public void add(T data){
        Node<T> node = new Node<T>(data);
        graph.putIfAbsent(node, new HashSet<Node<T>>());
    }

    public void addConection(T v1, T v2){
        Node<T> nv1 = new Node<T>(v1);
        Node<T> nv2 = new Node<T>(v2);
        add(v1);
        add(v2);
        graph.get(nv1).add(nv2);
        graph.get(nv2).add(nv1);
    }

    public void addConectionUni(T v1, T v2){
        Node<T> nv1 = new Node<T>(v1);
        Node<T> nv2 = new Node<T>(v2);
        add(v1);
        add(v2);
        graph.get(nv1).add(nv2);
    }

    public void printGraph(){
        for(Map.Entry<Node<T>, Set<Node<T>>> entry : graph.entrySet()){
            System.out.print(entry.getKey()+ " -> ");
            for(Node<T> conecciones : entry.getValue()){
                System.out.print(conecciones);
            }
            System.out.println();
        }

    }

    public Set<Node<T>> getVecino(T data){ 
        return graph.getOrDefault(new Node<>(data), new HashSet<Node<T>>()); 
    }
}