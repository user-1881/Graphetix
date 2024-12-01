package CustomUtilityFunctions;

public class CustomQueue<E> {
    private Node<E> head;
    private Node<E> tail;
    public boolean isEmpty() {
        return head == null;
    }

    public CustomQueue() {
        this.head = null;
        this.tail = null;
    }
    public void addQueue(E value)
    {
        Node<E> newNode = new Node<>(value);

        if (head == null)
        {
            head = newNode;
        }
        else
        {
            tail.next = newNode;

        }
        tail = newNode;

    }
    public void offer(E item) {
        Node<E> newNode = new Node<>(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public boolean addLast(E value) {
        Node<E> newNode = new Node<>(value);

        if (head == null) {

            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        return true;
    }
    public E pollQueue() {
        if (head == null) {
            return null;
        }
        E data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

}
