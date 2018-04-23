public class Student {
	//학생 객체가 가질 기능
	//평균 구하는 기능
	//출력기능
	
	//가지는 데이터
	//이름, 국어, 영어, 수학
	
	String name;
	int kor;
	int eng;
	int math;
	double avg;
	
	//평균 계산기능 == 메서드
	//수식자 반환값 이름() {
	//
	//}
	
	public void calAvg() {
		avg = (math + eng + kor)/3;
		
		
	}
	
	//출력기능
	
	public void printStudent() {
		System.out.println("이름 : "+name);
		System.out.println("평균 : "+avg);
	}
	
	
	
	
	
	
	
	
}