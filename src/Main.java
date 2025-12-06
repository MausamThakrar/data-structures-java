public class Main {
    public static void main(String[] args) {
        // LinkedList demo
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        list.prepend(0);
        list.insertAt(2, 5);
        System.out.println(list);

        // Stack demo
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        System.out.println("Stack peek: " + stack.peek());
        System.out.println("Stack pop: " + stack.pop());

        // Queue demo
        Queue<String> queue = new Queue<>();
        queue.enqueue("x");
        queue.enqueue("y");
        System.out.println("Queue peek: " + queue.peek());
        System.out.println("Queue dequeue: " + queue.dequeue());

        // BST demo
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        for (int v : values) bst.insert(v);
        StringBuilder inorder = new StringBuilder();
        bst.inorderTraversal(inorder);
        System.out.println("BST inorder: " + inorder);
        System.out.println("BST min: " + bst.findMin());
        System.out.println("BST max: " + bst.findMax());
        bst.delete(5);
        inorder.setLength(0);
        bst.inorderTraversal(inorder);
        System.out.println("BST inorder after deleting 5: " + inorder);

        // HashTable demo
        HashTable<String, Integer> ht = new HashTable<>();
        ht.put("a", 1);
        ht.put("b", 2);
        ht.put("a", 3);
        System.out.println("HashTable get('a'): " + ht.get("a"));
        System.out.println("HashTable size: " + ht.size());
    }
}
