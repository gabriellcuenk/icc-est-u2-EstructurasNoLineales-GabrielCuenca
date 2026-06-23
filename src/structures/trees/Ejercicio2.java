package structures.trees;

import structures.node.Node;

public class Ejercicio2 {
    public Node<Integer> invertTree(Node<Integer>root){

        invertRecursively(root);

        printTree(root);

        return root;
        

    }

    private void invertRecursively(Node<Integer> root){
        if(root == null){
            return;
        }

        Node<Integer> temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        invertRecursively(root.getLeft());
        invertRecursively(root.getRight());
    }

    public void printTree(Node<Integer> root){
        System.out.println("Imprimiendo el arbol");
        printTreeRecursivo(root,0);
    }



   private void printTreeRecursivo(Node<Integer> actual, int nivel) {
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
