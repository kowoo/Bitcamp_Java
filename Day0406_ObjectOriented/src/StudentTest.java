import java.util.Scanner;

public class StudentTest {
	public static void main(String[] args) {
		//학생 두명의 정보(이름, 국영수 점수)
		//각 학생의 이름과 평균을 출력하는 프로그램을 작성!
		//입출력 예
		//학생 이름을 입력하세요
		//홍길동
		//국어점수를 입력하세요 60, 영어점수를 입력하세요 70, 수학점수를 입력하세요 100
		//신사임당
		//국어점수를 입력하세요 100, 영어점수를 입력하세요 50, 수학점수를 입력하세요 70 
		//이름 : 홍길동 평균 : .1f
		//이름 : 신사임당 평균 : .1fSystem.out.println("이름 : "+name);
		
		Student1 s1 = new Student1();//홍길동
		Student1 s2 = new Student1();//신사임당
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요");
		s1.name = scan.nextLine();
		System.out.println("국어점수를 입력하세요");
		s1.kor = scan.nextInt();
		System.out.println("영어점수를 입력하세요");
		s1.eng = scan.nextInt();
		System.out.println("수학점수를 입력하세요");
		s1.math = scan.nextInt();
		
		scan.nextLine();
		
		System.out.println("이름을 입력하세요");
		s2.name = scan.nextLine();
		System.out.println("국어점수를 입력하세요");
		s2.kor = scan.nextInt();
		System.out.println("영어점수를 입력하세요");
		s2.eng = scan.nextInt();
		System.out.println("수학점수를 입력하세요");
		s2.math = scan.nextInt();
		
		System.out.println("이름 : " + s1.name);
		System.out.println("평균 : " 
		+ ((s1.eng+s1.kor+s1.math)/3));
		
		System.out.println("이름 : " + s2.name);
		System.out.println("평균 : " 
		+ ((s2.eng+s2.kor+s2.math)/3));
		
	}
}

class Student1 {
	String name;
	int kor;
	int eng;
	int math;
}