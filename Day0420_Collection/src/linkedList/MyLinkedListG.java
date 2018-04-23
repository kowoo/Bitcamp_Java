package linkedList;

public class MyLinkedListG<E> {
	//remove 다시하기
	//remove(int index)
	//set(int index,String data)
	private int size;
	private NodeG<E> head;

	public MyLinkedListG() {
		size=0;
		E head=null; //데이터가 없으면(길이가 0이면) 노드는 존재하지 않는다.
	}

	public void add(E data) {
		if(head == null) {
			head = new NodeG<E>(data);
		}else {
			NodeG<E> newNodeG = new NodeG<E>(data);
			getTail().setNext(newNodeG);
		}
		size++;
	}
	
	public NodeG<E> get(int index) {
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
	
	public void set(int index, E data) {
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

	public NodeG<E> getTail() {
		NodeG<E> tail = head;
		for(int i=1; i<size ; i++) {
			tail = tail.next();
		}		
		return tail;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();	
		NodeG<E> cur = head;
		for(int i=0; i<size; i++) {
			sb.append(cur.getData()).append(" ");
			cur = cur.next();
		}
		return sb.toString();
	}

}
