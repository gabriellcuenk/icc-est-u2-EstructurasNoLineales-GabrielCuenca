import java.util.List;
import java.util.Set;

import collections.sets.Sets;
import models.Contacto;
/* import structures.trees.BinaryTree;
import structures.trees.Ejercicio1;
import structures.trees.Ejercicio2;
import structures.trees.Ejercicio4;
import structures.trees.Ejercicio3; */
import structures.trees.BinaryTree;
import structures.node.*;
import collections.maps.Maps;
// import java.util.Map;

import structures.graphs.PathFinder;
import structures.graphs.PathResult;


import structures.graphs.*;
import structures.graphs.implementations.DFSPathFinder;

public class App {
    public static void main(String[] args) throws Exception {

        // Ejercicios del informe
        // Ejercicio 1
        /* System.out.println("Ejercicio 1:");
        int[] numeros = {5,3,7,2,4,6,8};
        Ejercicio1 ejm = new Ejercicio1();
        ejm.insert(numeros);


        // Ejercicio 2
        System.out.println("Ejercicio 2:");
        Ejercicio2<Integer> ejm2 = new Ejercicio2<Integer>();
        BinaryTree<Integer> arbol = new BinaryTree<>();
        BinaryTree<Integer> arbol2 = new BinaryTree<>();
        for(int numEjm : numeros){
            arbol.insert(numEjm);
            arbol2.insert(numEjm);
        }
        ejm2.invertTree(arbol2.getRoot());

        // Ejercicio 3
        Ejercicio3<Integer> levels = new Ejercicio3<>();
        System.out.println("Ejercicio 3:");
        System.out.println("Niveles del arbol:");
        System.out.println(levels.listLevels(arbol.getRoot()));

        // Ejericicio 4
        System.out.println("Ejercicio 4:");
        Ejercicio4<Integer> ejm4 = new Ejercicio4<Integer>();
        System.out.println("Profundidad máxima del arbol " + ejm4.maxDepth(arbol.getRoot()));
        */

        // runSets();

        // runMaps();

        runGraph2();
        
    }

    private static void runSets() {
        Sets sets = new Sets();
        //Primera implementacion hashSet
        System.out.println("HashSet:");
        Set<String> hashSet = sets.construirHashSet();
        System.out.println(hashSet);
        System.out.println("Tamaño: " + hashSet.size());
        System.out.println(hashSet.contains("F"));

        //Segunda implementacion linkedHashSet
        System.out.println("LinkedHashSet:");
        Set<String> linkedHashSet = sets.construirLinkedHashSet();
        System.out.println(linkedHashSet);
        System.out.println("Tamaño: " + linkedHashSet.size());
        System.out.println(linkedHashSet.contains("F"));

        //Tercera implementacion treeSet
        System.out.println("TreeSet:");
        Set<String> treeSet = sets.construirTreeSet();
        System.out.println(treeSet);
        System.out.println("Tamaño: " + treeSet.size());
        System.out.println(treeSet.contains("F"));

        //Cuarta implementacion treeSet con comparador
        System.out.println("TreeSet con comparador:");
        Set<Contacto> tCSet = sets.construirTreeSetConComparador();
        System.out.println(tCSet);
        System.out.println(tCSet.size());

        // Quinta implementacion HashSet con objetos Contacto
        System.out.println("HashSet con objetos Contacto:");
        Set<Contacto> hCSet = sets.construirHashSetContacto();
        System.out.println(hCSet);
        System.out.println(hCSet.size());
    }

    private static BinaryTree<Integer> construirArbol(int[] numeros) {
        BinaryTree<Integer> arbol = new BinaryTree<>();
        for (int numero : numeros) {
            arbol.insert(numero);
        }
        return arbol;
    }
 
    // Imprime cada nivel como una cadena: valor -> valor -> valor
    private static void imprimirNiveles(List<List<Node<Integer>>> niveles) {
        for (List<Node<Integer>> nivel : niveles) {
            for (int i = 0; i < nivel.size(); i++) {
                System.out.print(nivel.get(i).getValue());
                if (i < nivel.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    private static void runMaps(){
        Maps maps = new Maps();
        maps.construirHashMap();
    }

    private static void runGraphs(){
        Graph<String> grafo = new Graph<>();
        grafo.add("A");
        grafo.add("B");
        grafo.add("C");
        grafo.add("D");
        grafo.add("J");
        grafo.addConectionUni("A", "B");
        grafo.addConectionUni("B", "C");
        grafo.addConectionUni("B","D");
        grafo.addConectionUni("C", "A");
        grafo.addConection("J", "D");
        grafo.addConection("C", "D");
        grafo.printGraph();
    }

    private static void runGraph2(){
        Graph<String> grafo = new Graph<>();
        grafo.addConection("A","B");
        grafo.addConection("A","C");
        grafo.addConection("B","D");
        grafo.addConection("C","J");
        grafo.addConectionUni("D", "E");
        grafo.addConection("E", "F");
        grafo.addConectionUni("K", "J");

        DFSPathFinder<String> dfs = new DFSPathFinder<String>();
        PathResult<String> result = dfs.find(grafo, "A","F");
        PathResult<String> result2 = dfs.find(grafo,"A","J");
        PathResult<String> result3 = dfs.find(grafo,"A","K");

        System.out.println(result+"\n"+result2+"\n"+result3);
    }
}
