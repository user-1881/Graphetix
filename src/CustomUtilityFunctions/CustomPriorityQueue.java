package CustomUtilityFunctions;
import java.util.Comparator;

public class CustomPriorityQueue<E> {
    private Node<E> head;
    private Comparator<E> comparator;
    public CustomPriorityQueue(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null || comparator.compare(head.data, element) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null && comparator.compare(current.next.data, element) <= 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    public E poll() {
        if (head == null) {
            return null;
        }
        E data = head.data;
        head = head.next;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

}