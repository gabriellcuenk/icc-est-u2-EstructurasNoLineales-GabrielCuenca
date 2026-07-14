package structures.trees;
import structures.node.Node;

// Clase que representa un árbol binario de enteros

public class IntTree {

    private Node<Integer> root;
    public int peso;

    /// Constructor SIEMPRE inicializa LAS VARIABLES (ROOT)
    public IntTree() {
        this.root = null;
        this.peso = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public void setRoot(Node<Integer> node) {
        root = node;
    }

    public void setRoot(Integer value) {
        Node<Integer> node = new Node<Integer>(value);
        root = node;
    }

    public void insert(Integer value) { // 10
        Node<Integer> node = new Node<Integer>(value);
        root = insertRecursivo(root, node);
    }

    public void insert(Node<Integer> value) { // 10
        root = insertRecursivo(root, value);
        peso ++;
    }

    // recursivo para insertar valores ARBOL BINARIO
    private Node<Integer> insertRecursivo(Node<Integer> actual, Node<Integer> nodeInsertar) {
        if (actual == null) {
            return nodeInsertar;
        }

        // validar si es mayoy o nenor y decidir si lo ingerso a la der o izq
        if (actual.getValue() > nodeInsertar.getValue()) {
            actual.setLeft(insertRecursivo(actual.getLeft(), nodeInsertar));
        } else {
            actual.setRight(insertRecursivo(actual.getRight(), nodeInsertar));
        }

        return actual;
    }

    //PreOrder

    public void preOrder() {
        preOrderRecursivo(root);
    }

    private void preOrderRecursivo(Node<Integer> actual) {
        if (actual == null)
            return;
        System.out.print(actual + " ");
        preOrderRecursivo(actual.getLeft());
        preOrderRecursivo(actual.getRight());
    }

    // PosOrder

    public void posOrder() {
        posOrderRecursivo(root);
    }

    private void posOrderRecursivo(Node<Integer> actual) {
        if (actual == null)
            return;
        posOrderRecursivo(actual.getLeft());
        posOrderRecursivo(actual.getRight());
        System.out.print(actual + " ");

    }


    // inorder

    public void inOrder() {
        inOrderRecursivo(root);
    }

    private void inOrderRecursivo(Node<Integer> actual) {
        if (actual == null)
            return;
        inOrderRecursivo(actual.getLeft());
        System.out.print(actual + " ");
        inOrderRecursivo(actual.getRight());
    }

    // niveles

    public void niveles() {
        nivelesRecursivo(root, 0);
    }

    private void nivelesRecursivo(Node<Integer> actual, int nivel) {
        if (actual == null)
            return;
        System.out.println("Nivel " + nivel + ": " + actual);
        nivelesRecursivo(actual.getLeft(), nivel + 1);
        nivelesRecursivo(actual.getRight(), nivel + 1);
    }

    // altura

    public int altura() {
        return alturaRecursivo(root);
    }

    private int alturaRecursivo(Node<Integer> actual) {
        if (actual == null)
            return 0;
        int alturaIzquierda = alturaRecursivo(actual.getLeft());
        int alturaDerecha = alturaRecursivo(actual.getRight());
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    // cantidad de nodos / Peso

    public int peso() {
        return pesoRecursivo(root);
    }

    private int pesoRecursivo(Node<Integer> actual) {
        if (actual == null)
            return 0;
        int pesoIzquierdo = pesoRecursivo(actual.getLeft());
        int pesoDerecho = pesoRecursivo(actual.getRight());
        return pesoIzquierdo + pesoDerecho + 1;
    }

    public int getPeso() {
        return peso();
    }
}