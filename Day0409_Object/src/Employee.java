
public class Employee {
	//이름, 연봉, 부서를 상태값으로 가지는 클래스
	//상태를 출력하는 printEmployee()
	//정보를 받아와서 설정하는 setInfo(Employee e)
	
	String name; //이름 정보
	int salary; //연봉 정보
	String deptName; //부서 정보
	
	public void printEmployee() {
		System.out.println("이름 : "+name);
		System.out.println("연봉 : "+salary);
		System.out.println("부서 : "+deptName);
	}
	
	//
	public void setInfo(Employee e) {
		name = e.name;
		salary = e.salary;
		deptName = e.deptName;
		
		e.name = "완료";
		e.salary = 0;
		e.deptName = "완료";
	}
	
}
