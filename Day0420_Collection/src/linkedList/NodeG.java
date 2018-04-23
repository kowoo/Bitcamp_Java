package linkedList;

	//제네릭으로 바꿀때 반환형 타입이나 입력할 타입의 수정을 주의해야한다.
public class NodeG<T>{
	private T data; //문자열 하나를 저장할 수 있는 노드
	private NodeG<T> next;
	//LinkedList
	//next(): 다음 node의 주소값을 반환하는 메서드
	public NodeG() {}
	public NodeG(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public NodeG<T> next() {
		return next;
	}
	
	public void setNext(NodeG<T> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return data+" ";
	}
	
}
