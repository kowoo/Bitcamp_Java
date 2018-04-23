package linkedList;

public class NodeTest {
	public static void main(String[] args) {
		Node n1 = new Node("A");
		Node n2 = new Node("B");
		n1.setNext(n2);
		System.out.println(n1.next());
		
		Node n3 = new Node("C");
		n1.next().setNext(n3);
		System.out.println(n1.next().next());
		
//		Node n4 = new Node("D");
//		n1.next().next().setNext(n4);
//		System.out.println(n1.next().next().next());
		
		Node current = n1;
		for(int i=0; i<2 ;i++) {
			//System.out.println(current);
			current = current.next();
		}
		System.out.println(current);
		
	}
}
