import structures.trees.BinaryTree;
import structures.trees.Ejercicio1;
import structures.trees.Ejercicio2;


public class App {
    public static void main(String[] args) throws Exception {
        int[] numeros = {5,3,7,2,4,6,8};
        Ejercicio1 ejm = new Ejercicio1();
        ejm.insert(numeros);

        Ejercicio2 ejm2 = new Ejercicio2();
        BinaryTree<Integer> arbol = new BinaryTree<>();
        for(int numEjm : numeros){
            arbol.insert(numEjm);
        }
        ejm2.invertTree(arbol.getRoot());
        
    }
}
