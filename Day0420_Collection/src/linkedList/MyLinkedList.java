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
			head = new Node();
		}else {
			Node newNode = new Node(data);
			head.setNext(newNode);
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
		//지우려는 인덱스의 전에 있는 노드(index-1)를 선택
				//해당노드의 next를 지우려는 node의 next로 지정
				//cur : 지우려는 노드
				//prev : 이전 노드
				//0번 노드를 지우려고 할때 예외 처리 하기
				//지우려는 노드가 0번(head)이라면
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
	
	public void set(int index, String data) {
		for(int i=0; i<size ; i++) {

				head.setData(data);

				head = head.next();
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
