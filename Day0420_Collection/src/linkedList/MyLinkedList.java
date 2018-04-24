package linkedList;

public class MyLinkedList {
	private int size;
	private Node head;

	public MyLinkedList() {
		size=0;
		head=null; //데이터가 없으면(길이가 0이면) 노드는 존재하지 않는다.
	}

	public void add(String data) {
		if(head == null) {
			head = new Node(data);
		}else {
			Node newNode = new Node(data);
			getTail().setNext(newNode);
		}
		size++;
	}
	
	public Node get(int index) {
		for(int i=0; i<index; i++) {
			head = head.next();
		}
		return head;
	}
	
	public void remove(int index) {
		if(index==0) {
			head = head.next();
		}else {
			for(int i=0; i<size; i++) {
				if(i==index-1) {
					head.setNext(head.next().next());
				}else {
					head = head.next();
				}
			}
		}
		size--;
	}
	
	public void set(int index, String data) {
		for(int i=0; i<size ; i++) {
			if(i==index) {
				head.setData(data);
			}else {
				head = head.next();
			}
		}
	}
	
	public int size() {
		return size;
	}

	public Node getTail() {
		Node tail = head;
		for(int i=1; i<size ; i++) {
			tail = tail.next();
		}		
		return tail;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();	
		Node cur = head;
		for(int i=0; i<size; i++) {
			sb.append(cur.getData()).append(" ");
			cur = cur.next();
		}
		return sb.toString();
	}

}
