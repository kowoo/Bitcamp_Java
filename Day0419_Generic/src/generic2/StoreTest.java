package generic2;

public class StoreTest {
	public static void main(String[] args) {
		//제네릭 객체는 다양한 종류의 데이터를 저장할 수 있지만
		//객체를 만들 때 어떤 종류의 데이터를 저장할지 결정해줘야한다.
		Store<String> s1 = new Store<String>();
		//s1: 문자열을 저장할 수 있는 Store 객체
		s1.setData("Hello!!");
		String str = s1.getData();
		System.out.println(str);
		
		Store<Integer> s2 = new Store<Integer>();
		//s2: 정수를 저장할 수 있는 Store 객체, 제네릭은 기초 자료형 사용불가
		s2.setData(10);
		int a = s2.getData();
//		Integer a = new Integer(100);
//		int b = a;
//		System.out.println(b); 가능
		System.out.println(a);
		
		//참조 변수는 하나인데 여러 종류의 객체를 참조 시켜서 사용
		Object o = new String("Hello");
		o = new Integer(100);
		o = new Shape();
		
		//제네릭 참조 변수에 어떤 데이터 타입의 제네릭 객체가 참조될지 모를때
		//와일드 카드를 사용할 수 있다.
		//종류
		//? 			: 모든 데이터 타입의 제네릭 객체 참조 가능 
		//? super 클래스 	: 클래스 자신 또는 슈퍼클래스의 제네릭 객체 참조 가능
		//? extends	클래스: 클래스 자신 또는 서브클래스의 제네릭 객체 참조 가능
		
		Store<?> g = new Store<String>();
		//g = new Store<Integer>();
		System.out.println(g);
		
		// Shape shape = new Rectangle(); 이건 가능함
		// Store<Shape> s = new Store<Rectangle>(); 이러면 안됨. 왜? 도형이 아니라 직사각형이잖아
		Store<? extends Shape> s = new Store<Rectangle>(); // 이렇게 하면 된다. 왜? 와일드카드(extends)라 상속된 녀석들도 객체 참조 가능
		Store<? super Rectangle> rect = new Store<Shape>(); // 와일드카드(super)라 부모도 객체 참조 가능. 하지만 서브클래스들은 불가. 본인만 가능(트라이앵글, 써클 안됨)
	
		
	}
}
