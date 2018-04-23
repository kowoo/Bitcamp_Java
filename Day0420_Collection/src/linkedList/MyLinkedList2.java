package linkedList;

public class MyLinkedList2 {
	//MyLinkedList에 아래 기능 모두 구현하기 
	//remove(int index)
	//get(int index)
	//size()
	//add(String data) 
	//set(int index,String data)
	
	
	//얘가 가져야할 값
	//Node에 데이터를 저장해야한다.
	//첫번째 노드만 저장하고 있으면 연결되어있는 모든 노드에 접근 가능!
	//데이터가 몇개있는지를 알아야 한다 (size)
	private int size;
	private Node head;

	public MyLinkedList2() {
		size=0;
		head=null;
	}
	//추가하기 add(String)
	//Node를 하나 만든 뒤, 맨 마지막 노드의 next에 붙이기!
	public void add(String data) {
		//맨 마지막 노드 가져오는 기능도 있어야 한다! (꼬리니까 getTail()로 해보자?)
		if(head == null) {
			//head가 null이면 아무 데이터도 없기 때문에 next를 하지 못한다.
			//그래서 만든거야!
			head = new Node(data);
		}else {
			//head가 존재하면 마지막 노드를 얻어와서 새로운 노드를 마지막 노드의 next에 추가한다.
			Node newNode = new Node(data);
			getTail().setNext(newNode);
		}
		size++;
	}

	/* 마지막 노드를 가져오는 메서드
	 * [head] [e] [e] [e] [e] [tail]
	 * 길이는 6, 다섯번 next를 호출하면 길이 6에서 마지막 노드를 가져올 수 있음
	 * [head] 길이 1이면 next를 0번 호출해야한다.
	 */
	public Node getTail() {
		Node tail = head;
		
		for(int i=1; i<size ; i++) {
			tail = tail.next();
		}		
		
		while(tail.next()!=null) {
			tail = tail.next();
		}
		//위나 아래나 같다. 편한걸로 ㄱ
		
		return tail;
	}
	
	public String toString() {
		// 노드들의 데이터를 하나씩 추가해서 문자열로 만든 뒤 반환
		StringBuilder sb = new StringBuilder();
		Node cur = head;
		for(int i=0; i<size; i++) {
			sb.append(cur.getData()).append(" ");
			cur = cur.next();
		}
		return sb.toString();
	}


}
