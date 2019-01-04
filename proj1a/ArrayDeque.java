public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[4];
        size = 0;
        nextFirst = 2;
        nextLast = 3;
    }

    /** to increase the nextFirst or nextLast. */
    private int increase(int next){
        if (next == items.length - 1){
            return 0;
        }else{
            return next + 1;
        }
    }
    /** to decrease the nextFirst or nextLast. */
    private int decrease(int next){
        if (next == 0){
            return items.length - 1;
        }else{
            return next - 1;
        }
    }

    private void resize(int capacity){
        T[] resized = (T[]) new Object[capacity];
        int first = increase(nextFirst);
        int last = decrease(nextLast);

        if(first < last){
            System.arraycopy(items, first, resized, 0, size);
        }else{
            System.arraycopy(items, first, resized, 0, items.length - first);
            System.arraycopy(items, 0, resized, items.length - first, last + 1);
        }
        items = resized;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void addFirst(T item){
        if(size == items.length){
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = decrease(nextFirst);
        size += 1;
    }

    public void addLast(T item){
        if(size == items.length){
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = increase(nextLast);
        size += 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i = increase(nextFirst); i != decrease(nextLast); i = increase(i)){
            System.out.print(items[i]);
        }
}

    public T removeFirst(){
        if(size > 0) {
            int index = increase(nextFirst);
            T x = items[index];
            items[index] = null;
            nextFirst = index;
            return x;
        }
        return null;
    }

    public T removeLast(){
        if(size > 0) {
            int index = decrease(nextLast);
            T x = items[index];
            items[index] = null;
            nextLast = index;
            return x;
        }
        return null;
    }

    public T get(int index){
        if(size == 0){
            return null;
        }
        index = (index + increase(nextFirst)) % items.length;
        return items[index];
    }
}
