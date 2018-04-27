package myList;

public class MyList {
	private Node head;
	private int size;


	public MyList() {
		head = null;
		size = 0;
	}

	public void add(String data) {
		if(head==null) {
			head = new Node(data);
		} else {
			Node newNode = new Node(data);
			getTail().setNext(newNode);
		}
		size++;
	}

	public String get(int index) {
		String str =null;
		Node cur = head;
		for(int i=0; i<index; i++) {
			cur = cur.next();
		}
		str = cur.getData();
		return str;
	}

	public void remove(int index) {
		if(index == 0) {
			head = head.next();
		}else {			
			Node cur = head;
			Node prev = null;
			for(int i =0;i<index;i++) {
				prev = cur;
				cur = cur.next();
			}
			//cur: 지우려는 노드
			//prev : 지우려는 노드 앞 노드
			prev.setNext(cur.next());
		}
		size--;
	}

	public Node getTail() {
		Node tail = head;
		for(int i=1; i<size ; i++) {
			tail = tail.next();
		}		
		return tail;
	}

	public void set(int index, String data) {
		Node cur = head;
		for(int i=0; i<index ; i++) {
			cur = cur.next();
		}
		cur.setData(data);
	}

	public int size() {
		return size;
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
