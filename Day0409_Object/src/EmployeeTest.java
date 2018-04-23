
public class EmployeeTest {
	public static void main(String[] args) {
		//값에 의한 전달, 참조에 의한 전달 실습 예제
		//홍길동, 2000, 영업
		
		Employee hong = new Employee();
		hong.name = "홍길동";
		hong.salary = 2000;
		hong.deptName = "영업";
		System.out.println("hong1: ");
		hong.printEmployee();
		
		Employee copy = new Employee();
		System.out.println("copy1: ");
		copy.printEmployee();
		copy.setInfo(hong); //hong 객체가 가지는 데이터를 셋팅
		
		System.out.println("hong2: ");
		hong.printEmployee();
		
		System.out.println("copy2: ");
		copy.printEmployee();
	}
}
