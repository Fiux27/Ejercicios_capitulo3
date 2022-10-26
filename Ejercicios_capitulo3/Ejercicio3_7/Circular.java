public class Circular<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }
     // variables de instancia de CircularlyLinkedList
     private Node<E> tail = null;  // almacenamos la cola (pero no la cabeza)
     private int size = 0;  // número de nodos en la lista
 
     public Circular() { }  // constructores una lista inicialmente vacía
 
     // métodos de acceso
     public int size() {
         return size;
     }
 
     public boolean isEmpty() {
         return size == 0;
     }
 
     public E first() {
         if (isEmpty()) {
             return null;
         }
         return tail.getNext().getElement();  // la head es *después* de la cola
     }
     public E last() {  // devuelve (pero no elimina) el último elemento
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    // métodos de actualización
    public void rotate() {  // girar el primer elemento al final de la lista
        if (tail != null) {  // si está vacío, no hacer nada
            tail = tail.getNext();  // la vieja cabeza se convierte en la nueva cola
        }
    }

    public void addFirst(E e) {  // añade el elemento e al principio de la lista
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);  // se enlaza a sí mismo circularmente
        } else {
            //Node<E> newest = new Node<>(e, tail.getNext());
            //tail.setNext(newest);
            tail.setNext(new Node <>(e, tail.getNext()));
        }
        size++;
    }

    public void addLast(E e) {  // añade el elemento 'e' al final de la lista
        addFirst(e);  // insertar un nuevo elemento al frente de la lista
        tail = tail.getNext();  // ahora el nuevo elemento se convierte en la cola
    }

    public E removeFirst() {  // elimina y devuelve el primer elemento
        if (isEmpty()) {
            return null;  // nada que eliminar
        }
        Node<E> head = tail.getNext();
        if (head == tail) {
            tail = null; // debe ser el único nodo que queda
        } else {
            tail.setNext(head.getNext());  // elimina la "cabeza" de la lista
        }
        size--;
        return head.getElement();
    }
}
