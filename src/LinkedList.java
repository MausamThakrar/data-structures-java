public class LinkedList<T> {

    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;

    public void append(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    public void prepend(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
    }

    public void insertAt(int index, T value) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index == 0) {
            prepend(value);
            return;
        }
        Node<T> current = head;
        int pos = 0;
        while (current != null && pos < index - 1) {
            current = current.next;
            pos++;
        }
        if (current == null) throw new IndexOutOfBoundsException();
        Node<T> node = new Node<>(value);
        node.next = current.next;
        current.next = node;
    }

    public boolean deleteValue(T value) {
        Node<T> current = head;
        Node<T> prev = null;
        while (current != null) {
            if ((current.value == null && value == null) ||
                (current.value != null && current.value.equals(value))) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LinkedList[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
