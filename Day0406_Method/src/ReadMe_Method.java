
public class ReadMe_Method {
	// 펑션, 함수라고 이해해도 됨.
	public static void main(String[] args) {

		//		A가 학교에 가는 프로그램을 작성
		//		System.out.println("A가 일어난다.");
		//		System.out.println("A가 씻는다.");
		//		System.out.println("A가 밥을 먹는다.");
		//		System.out.println("A가 버스를 탄다.");
		//		System.out.println("A가 공부를 한다.");
		//		System.out.println("A가 귀가를 한다.");
		//		System.out.println("A가 씻고 잠을 잔다.");
		//		goSchoolA(); //메서드 호출
		//		goSchoolB();
		
		int a = 3+5;
		int b = goSchool("A"); 		//파라미터를 정의하면
		goSchool("B");			 	//인자(argument)를 넘겨줘야 한다.
		System.out.println("Do Something");
		System.out.println("b : "+b);
	}
	
	/* 메thㅝ드 모양
	 * [수식자] 반환형 식별자([매개변수]) {	*수식자나 매개변수는 없어도 된다
	 * 		반환값;
	 * }
	 */
	public static int goSchool(String str) {	//이름이 같으면 오류가 발생하므로 B로 변경. 같아도 오류 안나게 할 수 있음
		//메서드의 외부로부터 값을 받아오는 방법
		//>>> 매개변수, 파라미터(parameter)
		String name = str; //외부로부터 받아온 값을 사용한다.
		System.out.println(name+"가 일어난다.");
		System.out.println(name+"가 씻는다.");
		System.out.println(name+"가 밥을먹는다.");
		System.out.println(name+"가 버스를탄다.");
		System.out.println(name+"가 공부를한다.");
		System.out.println(name+"가 귀가를 한다.");
		System.out.println(name+"가 씻고 잠을잔다.");
		return 1; //결과값을 반환.
		//메서드를 실행하고 메서드를 호출한 값에 리턴 값을 저장한다.
		// int b = goSchool("A"); 를 입력한다면 고스쿨이 실행되고 b값에는 1이 저장되는 셈.
	}
}

//	public static void goSchoolA() {			//매개변수 없음
//		System.out.println("A가 일어난다.");
//		System.out.println("A가 씻는다.");
//		System.out.println("A가 밥을 먹는다.");
//		System.out.println("A가 버스를 탄다.");
//		System.out.println("A가 공부를 한다.");
//		System.out.println("A가 귀가를 한다.");
//		System.out.println("A가 씻고 잠을 잔다.");	
//	}
//	public static void goSchoolB() {			//이름이 같으면 오류가 발생하므로 B로 변경. 같아도 오류 안나게 할 수 있음
//		System.out.println("B가 일어난다.");
//		System.out.println("B가 씻는다.");
//		System.out.println("B가 밥을 먹는다.");
//		System.out.println("B가 버스를 탄다.");
//		System.out.println("B가 공부를 한다.");
//		System.out.println("B가 귀가를 한다.");
//		System.out.println("B가 씻고 잠을 잔다.");
//
//	}