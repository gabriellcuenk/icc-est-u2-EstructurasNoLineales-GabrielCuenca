package structures.trees;

import structures.node.Node;


public class Ejercicio4<T> {
    public int maxDepth(Node<T> root){
        return alturaRecursivo(root);
    }

    private int alturaRecursivo(Node<T> actual){
        if(actual == null)
            return 0;
        int alturaIzquierda = alturaRecursivo(actual.getLeft());
        int alturaDerecha = alturaRecursivo(actual.getRight());

        return Math.max(alturaIzquierda, alturaDerecha)+1;

    }
}
