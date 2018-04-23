package linkedList;

public class MyListTest2 {
	public static void main(String[] args) {
		MyLinkedListG<Object> list = new MyLinkedListG<Object>();
		list.add("A");
		list.add(100);
		list.add('T');
		list.add("z");
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
