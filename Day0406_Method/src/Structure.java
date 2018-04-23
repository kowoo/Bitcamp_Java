
public class Structure {

	public static void main(String[] args) {
		//구조체, structure
		//다양한 데이터를 한꺼번에 처리하기 위해서 사용
		//이름,나이,점수,학년
		//문자열,정수,실수,정수
		//자바에서는 class를 이용한다. 
		
		Student s1 = new Student(); //클래스 스튜던트의 사용자 정의 변수를 만듬. 
		s1.name = "홍길동";
		s1.age = 17;
		s1.grade = 3;
		s1.score = 99.9;
		
		Student s2 = new Student(); 
		s2.name = "이순신";
		s2.age = 28;
		s2.grade = 13;
		s2.score = 60;
		
		
		System.out.println("이름 : "+s1.name);
		System.out.println("나이 : "+s1.age);
		System.out.println("학년 : "+s1.grade);
		System.out.println("점수 : "+s1.score);
		System.out.println();
		
		System.out.println("이름 : "+s2.name);
		System.out.println("나이 : "+s2.age);
		System.out.println("학년 : "+s2.grade);
		System.out.println("점수 : "+s2.score);
		System.out.println();
		
		System.out.printf("이름 : %s	이름 : %s%n", s1.name, s2.name);
		System.out.printf("나이 : %d		나이 : %d%n", s1.age, s2.age);
		System.out.printf("학년 : %d		학년 : %d%n", s1.grade, s2.grade);
		System.out.printf("점수 : %.1f	점수 : %.1f%n", s1.score, s2.score);
		System.out.println();
		
		
	}//main end
}//class end
class Student{   //<<< 사용자 정의 데이터 타입
	//Student 클래스를 이용해서 여러 종류의 데이터를 한꺼번에 처리
	//이름,나이,점수,학년
	String name;
	int age;
	double score;
	int grade;
}
