

public class CircularLinkedList<E> {
    
        private static class Node<E> {
        private E e;
        private Node<E> next;

        public Node(E e, Node<E> n) { this.e = e; this.next = n; }
        public E getElement() { return e; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
    }
    
    private Node<E> tail;
    private int size;

    public CircularLinkedList() {}
    public int size() { return size; }
    public boolean isEmpty()  { return size ==0; }

    public E first() {
        return isEmpty() ? null : tail.getNext().getElement();
    }

    public E last() {
        return isEmpty() ? null : tail.getElement();
    }

    public void addFirst(E e) {
        if(isEmpty()) {
        tail = new Node<E>(e, null);
        tail.setNext(tail);
        }
        else {
        tail.setNext(new Node<E>(e, tail.getNext()));
        }
        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

        public E removeFirst() {
            if(isEmpty())
            return null;

            Node<E> head = tail.getNext();
            if(head == tail)
                tail = null;
            else
                tail.setNext(head.getNext());
            size--;
            return head.getElement();
        }

        public E removeLast() {
            if(isEmpty())
            return null;

            Node<E> head = tail.getNext();
            if(head == tail)
                tail = null;
            else
                tail.setNext(head.getNext());
            size--;
            return tail.getElement();
        }
    
    private static void onFalseThrow(boolean b) {
        if(!b)
        throw new RuntimeException("Error: inesperado");
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();

        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addFirst(1);

        onFalseThrow(list.removeLast() == 4);
        onFalseThrow(list.removeLast() == 3);
        onFalseThrow(list.removeFirst() == 1);
        onFalseThrow(list.removeLast() == 2);

        System.out.println("Éxito.");
    }
}
