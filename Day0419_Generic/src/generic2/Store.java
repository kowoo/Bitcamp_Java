package generic2;

public class Store<T> {
	//T를 하나의 타입처럼 사용하자
	private T data;
	
	public void setData(T data) {
		this.data = data;
	}
	public T getData() {
		return this.data;
	}
	public String toString() {
		return "data : "+data;
	}
	
	
}
