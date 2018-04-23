public class StudentTest {
	public static void main(String[] args) {
		Student s1 = new Student("a",1,new Score(20,30,40));
		
		System.out.println(s1);
		System.out.println();
		
	
		s1.setName("바보");
		s1.setGrade(3);
		s1.setEng(100);
		s1.setKor(100);
		s1.setMath(90);
		System.out.println(s1);
		
		
		
		
		
//		System.out.println("학생 이름을 입력하세요");
//		String name = sc.nextLine();
//		System.out.println("학년을 입력하세요");
//		int grade = sc.nextInt();
//		System.out.println("국어 점수를 입력하세요");
//		int kor = sc.nextInt();
//		System.out.println("영어 점수를 입력하세요");
//		int eng = sc.nextInt();
//		System.out.println("수학 점수를 입력하세요");
//		int math = sc.nextInt();
//		Student s = new Student(name, grade, kor, eng, math);
//		
//		System.out.println(s.);
		
	}
}
