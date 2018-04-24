package linkedList;

public class MyListTest2 {
	public static void main(String[] args) {
		MyLinkedListG2<Object> list = new MyLinkedListG2<Object>();
		list.add("A");
		list.add(100);
		list.add('T');
		list.add("z");
		System.out.println(list);
		System.out.println(list.getTail());
//		list.set(3, "F");
//		System.out.println(list);
		System.out.println(list.get(1));
//		list.remove(2);
//		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		
		//ListG와 ListG2의 차이점을 찾자!
		
	}
}
