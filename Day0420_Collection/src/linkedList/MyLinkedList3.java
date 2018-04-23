package linkedList;

public class MyLinkedList3 {
	//얘가 가져야할 값: 
		//Node에 데이터를 저장할 건데..
		//첫번째 노트만 저장하고 있으면 연결되어 있는 모든 노드들에 접근 가능
		//데이터가 몇개 있는지를 알아야 함 : size
		private int size;
		private Node head;
		
		public MyLinkedList3() {
			size = 0;
			head = null; //데이터가 없으면(길이가 0이면, 노드가 존재하면 X)
		}
		//추가 하기 add(String)
		//Node를 하나 만들어서, 맨마지막 노드의 next에 붙이기
		public void add(String data) {
			//맨마지막 노드 가져오는 메서드도 있어야 함 getTail():맨 마지막 노드의 주소값을 반환
			if(head == null) {
				//head가 null이면 아무 데이터도 없기 때문에 next를 하지 못함.
				head = new Node(data);
			}else {			
				//head가 존재하면 마지막 노드를 얻어와서 새로운 노드를 마지막 노드의 next에 추가
				Node newNode = new Node(data);
				getTail().setNext(newNode);
			}
			size++;
		}
		public String get(int index) {
			String str =null;
			//특정 인덱스에 있는 노드에 접근해서 문자열 가져오기
			//반복문 이용해서 해당 하는 index만큼 next() 호출
			
			Node cur = head; //인덱스가 0번이라면 next를 호출 할 필요가 없음 
			for(int i=0;i<index;i++) {
				cur = cur.next();
			}
			str = cur.getData();
			return str;
		}
		
		public void set(int index, String data) {
			Node cur = head;
			//특정인덱스에 있는 Node 얻어온 뒤
			for(int i=0; i<index; i++) {
				cur = cur.next();
			}
			//데이터 설정
			cur.setData(data);
		}
		
		
		//마지막 노드를 가져오는 메서드
		//[head][e][e][e][e][tail]
		//길이는 6, 다섯번 next를 호출하면 길이 6에서 마지막 노드를 가져올 수 있음
		//[head] 길이 1이면 next 0번 호출 해야됨
		public Node getTail() {
			
			Node tail = head;
//			for(int i=1;i<size;i++) {
//				tail = tail.next();
//			}
			//tail 사실은 next가 null인 노드를 찾으면 됩니다.
			while(tail.next() != null) {
				tail = tail.next();
			}
			return tail;
		}
		
		public void remove(int index) {
			//지우려는 인덱스의 전에 있는 노드(index-1)를 선택
			//해당노드의 next를 지우려는 node의 next로 지정
			
			//cur : 지우려는 노드
			//prev : 이전 노드
			
			//0번 노드를 지우려고 할때 예외 처리 하기
			//지우려는 노드가 0번(head)이라면
			if(index==0) {
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
			size--;
			}
		}
		
		public String toString() {
			//노드들의 데이터를 하나씩 추가해서 문자열 만들어서 반환 
			StringBuilder sb = new StringBuilder();
			
			Node cur = head;
			for(int i=0;i<size;i++) {
				sb.append(cur.getData()).append(" ");
				cur = cur.next();
			}
			return sb.toString();
		}
	
	
}
