public class BinaryTree<T extends Comparable<T>> {
    
    private Node<T> root;
    private int peso;

    public BinaryTree(){
        this.root=null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> node) {
        root = node;
    }

    public void setRoot(T value) {
        Node<T> node = new Node<T>(value);
        root = node;
    }

    public int getPeso(){
        return peso;
    }

    public void insert(T value) { // 10
        Node<T> node = new Node<T>(value);
        root = insertRecursivo(root, node);
        peso++;
    }

    public void insert(Node<T> value) { // 10
        root = insertRecursivo(root, value);
    }

    // recursivo para insertar valores ARBOL BINARIO
    private Node<T> insertRecursivo(Node<T> actual, Node<T> nodeInsertar) {
        if (actual == null) {
            return nodeInsertar;
        }

        // validar si es mayoy o nenor y decidir si lo ingerso a la der o izq
        if (actual.getValue().compareTo(nodeInsertar.getValue()) > 0) {
            actual.setLeft(insertRecursivo(actual.getLeft(), nodeInsertar));
        } else {
            actual.setRight(insertRecursivo(actual.getRight(), nodeInsertar));
        }

        return actual;
    }

    public void preOrder() {
        preOrderRecursivo(root);
    }

    private void preOrderRecursivo(Node<T> actual) {
        if (actual == null)
            return;
        System.out.print(actual + " ");
        preOrderRecursivo(actual.getLeft());
        preOrderRecursivo(actual.getRight());
    }

    public void posOrder() {
        posOrderRecursivo(root);
    }

    private void posOrderRecursivo(Node<T> actual) {
        if (actual == null)
            return;
        posOrderRecursivo(actual.getLeft());
        posOrderRecursivo(actual.getRight());
        System.out.print(actual + " ");

    }

    public void inOrder(){
        inOrderRecursivo(root);
    }

    private void inOrderRecursivo(Node<T> actual){
        if(actual == null)
            return;
        inOrderRecursivo(actual.getLeft());
        System.out.println(actual + " ");
        inOrderRecursivo(actual.getRight());
    }

    public int altura(){
        return alturaRecursivo(root);
    }

    private int alturaRecursivo(Node<T> actual){
        if(actual == null)
            return 0;
        int alturaIzquierda = alturaRecursivo(actual.getLeft());
        int alturaDerecha = alturaRecursivo(actual.getRight());

        return Math.max(alturaIzquierda, alturaDerecha)+1;

    }

    public int peso(){
        return pesoRecursivo(root);
    }
    
    private int pesoRecursivo(Node<T> actual){
        if(actual==null)
            return 0;
        int pesoIzquierda = pesoRecursivo(actual.getLeft());
        int pesoDerecha = pesoRecursivo(actual.getRight());
        return pesoDerecha+pesoIzquierda+1;
    }
}
