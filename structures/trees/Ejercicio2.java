package structures.trees;

import structures.node.Node;

public class Ejercicio2<T> {
    public Node<T> invertTree(Node<T>root){

        invertRecursively(root);

        printTree(root);

        return root;
        

    }

    private void invertRecursively(Node<T> root){
        if(root == null){
            return;
        }

        Node<T> temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        invertRecursively(root.getLeft());
        invertRecursively(root.getRight());
    }

    public void printTree(Node<T> root){
        System.out.println("Imprimiendo el arbol invertido");
        printTreeRecursivo(root,0);
    }



   private void printTreeRecursivo(Node<T> actual, int nivel) {
        if (actual == null)
            return;

        printTreeRecursivo(actual.getRight(), nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("\t");
        }
        System.out.println(actual.getValue());

        printTreeRecursivo(actual.getLeft(), nivel + 1);
    }

}
