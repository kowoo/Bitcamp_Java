
public class StudentArray {
	public static void main(String[] args) {
		//Student 객체를 배열에 넣고 관리하기
		Student[] studentArr = new Student[3];
		//Student 객체 3개(주소값 3개)를 저장할 수 있는 배열 생성
		
		studentArr[0] = new Student("홍길동", 3, new Score(100, 50, 50));
		studentArr[1] = new Student("신사임당", 2, new Score(50, 100, 40));
		studentArr[2] = new Student("김장금", 2, 100, 0, 100);
		
		for(Student s: studentArr) {
			System.out.println(s);
		}
		
	}
}