package myList;

public class Node {
	private String data;
	private Node next;
	
	
	public Node() {
	}	
	public Node(String data) {
		this.data = data;
	}
	
	public Node next() { //얘가 사실상 getter이라고 보면 됨.
		return next;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
	
}
