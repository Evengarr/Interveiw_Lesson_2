package linkedList;

public class MyLinkedList {
    static class Node<E> {  //класс описывающий элемент списка
        E item;             //значение элемента
        Node<E> next;       //указатель на следующий элемент
        Node<E> prev;       //указатель на предыдущий элемент
        int size = 0;

        public Node(Node<E> prev, E item, Node<E> next) {       //конструктор элемента списка
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        Node<E> last;   //последний элемент
        Node<E> first;  //первый элемент

        public void add(E newElement) {   //добавление нового элемента, по умолчанию он добавляется в конец списка
            Node<E> l = last;
            Node<E> newNode = new Node<>(l, newElement, null); //(newElement - значение нового элемента, l - предыдущий элемент)
            last = newNode;
            if (l == null) {
                first = newNode;
            } else l.next = newNode;
            size++;
        }

        public void addFirst(E newElement) {  //добавление нового элемента в начало списка
            Node<E> f = first;
            Node<E> newNode = new Node<>(null, newElement, f); //f - следующий элемент
            first = newNode;
            if (f == null) {
                last = newNode;
            } else f.prev = newNode;
            size++;
        }

        public void addInside(E newElement, Node<E> previous) { //добавление нового элемента в список перед определенным элементом
            Node<E> p = previous.prev;
            Node<E> newNode = new Node<>(p, newElement, previous);
            previous.prev = newNode;
            if (p == null) {
                first = newNode;
            } else p.next = newNode;
            size++;
        }

        public void clear() { //удалить все элементы списка
            for (Node<E> x = first; x != null; ) {
                Node<E> next = x.next;
                x.item = null;  // обнуляем значение элемента спика
                x.next = null;  // обнуляем указателя на следующий элемент
                x.prev = null;  // обнуляем указатель на предыдущий элемент
                x = next;
            }
            first = last = null;
            size = 0;
        }

        public int size() { //определение элементов списка
            return size;
        }
    }
}
