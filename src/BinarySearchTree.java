public class BinarySearchTree<T extends Comparable<T>> {

    private static class Node<T> {
        T key;
        Node<T> left;
        Node<T> right;
        Node(T key) {
            this.key = key;
        }
    }

    private Node<T> root;

    public void insert(T key) {
        root = insertRecursive(root, key);
    }

    private Node<T> insertRecursive(Node<T> node, T key) {
        if (node == null) return new Node<>(key);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = insertRecursive(node.left, key);
        else if (cmp > 0) node.right = insertRecursive(node.right, key);
        return node;
    }

    public boolean contains(T key) {
        Node<T> node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) return true;
            else if (cmp < 0) node = node.left;
            else node = node.right;
        }
        return false;
    }

    public void inorderTraversal(StringBuilder sb) {
        sb.append("[");
        inorder(root, sb);
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == ' ') {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
    }

    private void inorder(Node<T> node, StringBuilder sb) {
        if (node == null) return;
        inorder(node.left, sb);
        sb.append(node.key).append(", ");
        inorder(node.right, sb);
    }

    public T findMin() {
        if (root == null) return null;
        Node<T> node = root;
        while (node.left != null) node = node.left;
        return node.key;
    }

    public T findMax() {
        if (root == null) return null;
        Node<T> node = root;
        while (node.right != null) node = node.right;
        return node.key;
    }

    public void delete(T key) {
        root = deleteRecursive(root, key);
    }

    private Node<T> deleteRecursive(Node<T> node, T key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = deleteRecursive(node.left, key);
        } else if (cmp > 0) {
            node.right = deleteRecursive(node.right, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node<T> successor = node.right;
            while (successor.left != null) successor = successor.left;
            node.key = successor.key;
            node.right = deleteRecursive(node.right, successor.key);
        }
        return node;
    }
}
