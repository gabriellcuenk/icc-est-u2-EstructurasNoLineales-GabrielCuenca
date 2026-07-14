package structures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import structures.node.Node;

public class Ejercicio3<T> {

    public List<List<Node<T>>> listLevels(Node<T> root) {
        List<List<Node<T>>> resultado = new ArrayList<>();

        if (root == null) {
            return resultado;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node<T>> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                Node<T> actual = queue.poll();
                level.add(actual);

                if (actual.getLeft() != null) {
                    queue.offer(actual.getLeft());
                }

                if (actual.getRight() != null) {
                    queue.offer(actual.getRight());
                }
            }

            resultado.add(level);
        }

        return resultado;
    }
}