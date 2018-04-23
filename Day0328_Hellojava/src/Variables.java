
public class Variables {
	//필드 (멤버변수, 클래스변수)는 클래스 안에서 참조가능하다.
	//필드 : 클래스 영역에서 선언된 변수
	int a = 3;
	double b; //멤버변수

	public void method1(int a) { // ()안에 선언되는 변수 == 매개변수 == 지역변수와 같은 취급. 그러므로 같은 블록에 같은 이름으로 선언 불가. 블록 벗어나면 사용 불가
		/*
		변수를 사용한다 == 변수가 가지는 값을 가지고 온다.
		선언과 초기화가 필요
		선언 : 변수를 사용하기 위해서 메모리 공간을 할당 받음
		초기화 : 변수에 처음 값을 한 번 입력하는 작업
		 */
		double b; //메서드 영역안에서 선언된 변수 : 지역변수 == Local variable, 메서드 안에서만 사용 가능하다.
		// System.out.println(c); 초기화가 되지 않아서 사용 불가능
	}
	public void method2() {
		System.out.println(a);
		System.out.println(b); // 메인이 없어서 실행이 안됨
	}

}
