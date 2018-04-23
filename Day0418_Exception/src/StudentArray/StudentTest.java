package StudentArray;
public class StudentTest {
	public static void main(String[] args) {
		//Student 클래스가 제대로 작성되었는지 확인
		Student s1 = new Student();		
		System.out.println(s1);
		s1.setKor(100);
		s1.setName("홍길동");
		s1.setEng(0);
		s1.setMath(0);
		System.out.println(s1);
		
		Score score = new Score(100,50,50); 
		Student s2 = new Student("이순신",3,score);
		System.out.println(s2);
		System.out.println(s2.getAverage());
		
		
		Student s3 = new Student("신사임당",2,100,100,100);
		System.out.println(s3);
		System.out.println(s3.getAverage());
		
		
		
		
	}
}
