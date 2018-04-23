package linkedList;

public class MyListTest {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		System.out.println(list);
		System.out.println(list.getTail());
//		list.set(3, "F");
//		System.out.println(list);
		System.out.println(list.get(0));
//		list.remove(2);
//		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		
		
	}
}
