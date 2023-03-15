package a1;

public class SpecializedList implements SpecializedListInterface{
	
	
	SlistNode head;
	SlistNode tail;
	SlistNode currentf;
	SlistNode currentb;
	
	public static class SlistNode {
		
		Byte data;
		SlistNode next;
		SlistNode prev; 
 		
		public SlistNode(Byte data) {
			this.data = data;
		}
	}
	
	public SpecializedList() {
		this.head = null;
		this.tail = null;
		this.currentf = head;
		this.currentb = tail;
	}
	

	public void display() {
		currentf = head;
		while(currentf != null) {
			System.out.print(currentf.data + " --> ");
			currentf = currentf.next;
		}
		System.out.print("null");
		currentf = head;
	}
	
	public void displayReverse() {
		currentb = tail;
		while(currentb != null) {
			System.out.print(currentb.data + " --> ");
			currentb = currentb.prev;
		}
		System.out.print("null");
		currentb = tail;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpecializedList sll = new SpecializedList();
		SlistNode first = new SlistNode((byte) 10);
		SlistNode second = new SlistNode((byte) 1);
		SlistNode third = new SlistNode((byte) 8);
		SlistNode fourth = new SlistNode((byte) 11);
		sll.head = first;
		sll.tail = fourth;
		
		sll.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.prev = third;
		third.prev = second;
		second.prev = first;
		
		sll.display();
		System.out.print("\n");
		sll.displayReverse();
		sll.resetForward();
		sll.resetBackward();
		System.out.print("\n\n" + sll.getNextItem());
		System.out.print("\n" + sll.getNextItem());
		System.out.print("\n" + sll.getNextItem());
		System.out.print("\n" + sll.getNextItem());
		System.out.print("\n" + sll.getNextItem());
		System.out.print("\n" + sll.getNextItem());
		
		System.out.print("\n\n" + sll.getPriorItem());
		System.out.print("\n" + sll.getPriorItem());
		System.out.print("\n" + sll.getPriorItem());
		System.out.print("\n" + sll.getPriorItem());
		System.out.print("\n" + sll.getPriorItem());
		System.out.print("\n" + sll.getPriorItem());
		
		System.out.print("\n\n" + sll.lengthIs());
		sll.insertFront((byte) 69);
		System.out.print("\n");
		sll.display();
		sll.insertEnd((byte) 69);
		System.out.print("\n");
		sll.display();

	}

	@Override
	public void resetForward() {
		currentf = head;
		// TODO Auto-generated method stub
 	}

	@Override
	public byte getNextItem() {
		// TODO Auto-generated method stub
		byte x = currentf.data;

		if(currentf.next != null) {
			currentf = currentf.next;
		}else if(currentf.next == null){
		   currentf = head;
		   
	 
		}

		return (byte) x;
	}

	@Override
	public void resetBackward() {
		currentb = tail;
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte getPriorItem() {
		// TODO Auto-generated method stub
		byte x = currentb.data;
		if(currentb.prev != null) {
			currentb = currentb.prev;
		}else if(currentb.prev == null){
		   currentb = tail;
		}

		return (byte) x;
	}

	@Override
	public int lengthIs() {
		// TODO Auto-generated method stub
		int count = 0;
		SlistNode c = head;
		while(c != null) {
			c = c.next;
			count++;
		}
		return count;
	}

	@Override
	public void insertFront(byte item) {
		// TODO Auto-generated method stub
		SlistNode newNode = new SlistNode(item);
		if(head == null) {
			tail = newNode;
		}else {
			head.prev = newNode;
		}
		newNode.next = head;
		head = newNode;
		currentf = head;
		newNode.prev = null;
		
	}

	@Override
	public void insertEnd(byte item) {
		// TODO Auto-generated method stub
		SlistNode newNode = new SlistNode(item);
		if(tail == null) {
			head = newNode;
		}else {
			tail.next = newNode;
		}
		newNode.prev = tail;
		tail = newNode;
		currentb = tail;
		newNode.next = null;
		
	}

}

