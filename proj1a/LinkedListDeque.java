public class LinkedListDeque<T> {
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



    public void addFirst(T item){
        if (sentinel.next.equals(sentinel)){
            sentinel.next = new Node(sentinel, item, sentinel.next);
        }
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item){
        if (sentinel.prev.equals(sentinel)){
            sentinel.prev = new Node(sentinel.prev, item, sentinel);
        }
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    public boolean isEmpty(){
        if (sentinel.next.equals(sentinel)){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p = sentinel.next;
        while (p != sentinel){
            System.out.print(p.item);
            p = p.next;
        }

    }

    public T removeFirst(){
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return null;
    }

    public T removeLast(){
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return null;
    }

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
        LinkedListDeque<Integer> k = new LinkedListDeque<>();
        LinkedListDeque<Integer> l = new LinkedListDeque<>(4);
        l.addFirst(3);
        l.addFirst(2);
        l.addFirst(1);
        l.printDeque();
        System.out.println("Size: " + l.size());
        l.addLast(5);
        l.addLast(6);
        l.addLast(7);
        l.removeFirst();
        l.removeLast();
        l.removeLast();
        l.printDeque();
        l.printDeque();
        System.out.println("Size " + l.size());
        System.out.println(l.get(3));
        System.out.println(l.sentinel.next.next.item);
        System.out.println(l.sentinel.next.item);
        System.out.println(l.removeLast());
        l.printDeque();
        System.out.println(l.sentinel.next.item);
        System.out.println(l.getRecursive(0));

    }

}
