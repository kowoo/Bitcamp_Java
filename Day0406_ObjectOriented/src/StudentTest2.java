import java.util.Scanner;

public class StudentTest2 {
	public static void main(String[] args) {
		//사용자에게 입력받을 준비
		//입력받을 데이터 변수 == Student
		Scanner input = new Scanner(System.in);
		Student s1, s2;
		s1 = new Student();
		s2 = new Student();

		System.out.println("이름을 입력하세요");
		s1.name = input.nextLine();
		System.out.println("국어점수를 입력하세요");
		s1.kor = input.nextInt();
		System.out.println("영어점수를 입력하세요");
		s1.eng = input.nextInt();
		System.out.println("수학점수를 입력하세요");
		s1.math = input.nextInt();
		
		input.nextLine();
		
		System.out.println("이름을 입력하세요");
		s2.name = input.nextLine();
		System.out.println("국어점수를 입력하세요");
		s2.kor = input.nextInt();
		System.out.println("수학점수를 입력하세요");
		s2.math = input.nextInt();
		System.out.println("영어점수를 입력하세요");
		s2.eng = input.nextInt();
			
		
		/************************************/
		
		s1.calAvg();
		s1.printStudent();
		s2.calAvg();
		s2.printStudent();
		
	}
}