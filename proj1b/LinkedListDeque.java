public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(Node p, T i, Node n){
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(sentinel , null, sentinel);
        size = 0;
    }

    public LinkedListDeque(T x){
        sentinel = new Node(sentinel, null, sentinel);
        sentinel.next = new Node(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }


    @Override
    public void addFirst(T item) {
        if (isEmpty()){
        sentinel.next = new Node(sentinel, item, sentinel);
        sentinel.prev = sentinel.next;
        }else{
            sentinel.next = new Node(sentinel, item, sentinel.next);
            sentinel.next.next.prev = sentinel.next;
          }
        size += 1;
    }

    @Override
    public void addLast(T item){
        if (isEmpty()){
            sentinel.prev = new Node(sentinel, item, sentinel);
            sentinel.next = sentinel.prev;
        }else {
            sentinel.prev = new Node(sentinel.prev, item, sentinel);
            sentinel.prev.prev.next = sentinel.prev;
        }
        size += 1;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque() {
        Node p = sentinel.next;
        for(int i = 0; i < size(); i++){
            System.out.print(p.item);
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst(){
        if(sentinel.next == null){
            return null;
        }else if (sentinel.next.next == null){
            T x = sentinel.next.item;
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
            size -= 1;
            return x;
        }else {
            T x = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return x;
        }
    }

    @Override
    public T removeLast(){
        if(sentinel.prev.item == null){
            return null;
        }else if (sentinel.prev.prev == null){
          T x = sentinel.prev.item;
          sentinel.prev = sentinel;
          sentinel.next = sentinel;
          size -= 1;
          return x;
        } else {
            T x = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size -= 1;
            return x;
        }
    }

    @Override
    public T get(int index){
        Node p = sentinel.next;
        for (int i = 0; i < index + 1; i++ ){
            if (i == index){
                return p.item;
            }
            p = p.next;
        }
        return null;
    }

    private T getHelper(Node p, int i){
        if (i == 0){
            return p.item;
        }else if(i < 0){
            return null;
        }else{
            return getHelper(p.next, i - 1);
        }
    }

    public T getRecursive(int index){
        return getHelper(sentinel.next, index);
    }

    /** Testing out the LinkedListDeque class! */
    public static void main(String[] args) {
        LinkedListDeque<Integer> l = new LinkedListDeque<>();
        l.addFirst(3);
        l.addFirst(2);
        l.addFirst(1);
        l.printDeque();
        System.out.println("Size: " + l.size());
        l.addLast(5);
        l.addLast(6);
        l.addLast(7);
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeLast();
        l.removeLast();
        l.removeFirst();
        l.printDeque();
        System.out.println("Size: " + l.size());
        LinkedListDeque<Integer> k = new LinkedListDeque<>(4);
        k.addLast(1);
        k.addLast(2);
        k.addLast(3);
        k.addLast(4);
        k.addLast(5);
        k.addLast(6);
        k.addLast(7);
        k.addLast(8);
        k.addLast(9);
        System.out.println(k.removeFirst());
        k.removeLast();
        k.printDeque();
        System.out.println("Size: " + k.size());
        System.out.println(k.get(3));
        System.out.println(k.sentinel.next.next.item);
        System.out.println(k.sentinel.next.item);
        System.out.println(k.removeLast());
        k.printDeque();
        System.out.println(k.sentinel.prev.item);
        System.out.println(k.getRecursive(3));
    }
}
