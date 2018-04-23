
public class StudentTest {
	public static void main(String[] args) {
		Student s = new Student("사람", 4, 100, 100, 99);
		System.out.println(s);
		
		Student s2 = new Student("사람2", 1, new Score(100,200,300));
		System.out.println(s2);
	}
	
}
