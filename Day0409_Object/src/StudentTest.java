
public class StudentTest {
	public static void main(String[] args) {
		//Student 클래스를 작성
		//객체를 만들어서 객체의 멤버변수에 값을 넣고, 조회하고
		//메서드를 만들어서 객체 상태를 출력하는 기능
		//Student가 가져야할 상태값
		//이름(문자열), 학년(정수), 번호(정수)
		//Student 객체가 할 수 있는 동작
		//상태값 출력 (프린트스튜던트)
		//객체 2개 (s1, s2)를 만들고
		//각각의 값을 넣어주고
		//프린트스튜던트 활용해서 상태값 출력해보자
		//예
		//이름 : 홍길동
		//학년 : 3
		//번호 : 12
		//이름 : 이순신
		//학년 : 2
		//번호 : 10
		
		//객체를 사용하기 위해 참조변수가 필요하다(s1, s2)
		Student s1;
		s1 = new Student();
		s1.name = "홍길동";
		s1.grade = 3;
		s1.number = 12;
		s1.printStudent();
		
		Student s2 = new Student();
		s2.name = "이순신";
		s2.grade = 2;
		s2.number = 10;
		s2.printStudent();
		
		System.out.println(s1);
		System.out.println(s2);
		
	}

}
