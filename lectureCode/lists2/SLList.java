 /** An SLList is a list of integers, which hides the terrible truth
   * of the nakedness within. */
public class SLList {	
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	} 

	/* The first item (if it exists) is at sentinel.next. */
	private IntNode sentinel;
	private int size;


	/** Creates an empty SLList. */
	public SLList() {
		sentinel = new IntNode(63, null);
		size = 0;
	}

	public SLList(int x) {
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

 	/** Adds x to the front of the list. */
 	public void addFirst(int x) {
 		sentinel.next = new IntNode(x, sentinel.next);
 		size = size + 1;
 	}

 	/** Returns the first item in the list. */
 	public int getFirst() {
 		return sentinel.next.item;
 	}

 	/** Adds x to the end of the list. */
 	public void addLast(int x) {
 		size = size + 1; 		

 		IntNode p = sentinel;

 		/* Advance p to the end of the list. */
 		while (p.next != null) {
 			p = p.next;
 		}

 		p.next = new IntNode(x, null);
 	}
 	
 	/** Returns the size of the list. */
 	public int size() {
 		return size;
 	}

 	public void insert(int x, int position){
        if (position == 0 || sentinel.next == null){
            addFirst(x);
            return;
        }
        IntNode currentNode = sentinel.next;
        while(position > 1 && currentNode.next != null){
        	position--;
        	currentNode = currentNode.next;
        }
        IntNode newNode = new IntNode(x, currentNode.next);
        currentNode.next = newNode;
    }

    public void reverse(){
    	IntNode frontOfReversed = null;
    	IntNode nextNodeToAdd = sentinel.next;
    	while (nextNodeToAdd != null){
    		IntNode remainderOfOriginal = nextNodeToAdd.next;
    		nextNodeToAdd.next = frontOfReversed;
    		frontOfReversed = nextNodeToAdd;
    		nextNodeToAdd = remainderOfOriginal;
    	}
    	sentinel.next = frontOfReversed;
    }

	public static void main(String[] args) {
		SLList L = new SLList(5);
		L.addFirst(4);
		L.addFirst(3);
		L.addFirst(2);
		L.addFirst(1);
		L.insert(7, 1);
		L.reverse();
		System.out.println(L.getFirst());

		System.out.println(L.sentinel.next.next.item);
 	}
}