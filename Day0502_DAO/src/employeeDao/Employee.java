package employeeDao;

//모델 완료!
public class Employee {
	//직원번호(정수), 직원이름(문자열), 부서번호(정수), 월급(정수)
//	empNum: 직원번호
//	ename: 직원이름
//	deptno: 부서번호
//	salary: 월급
	private int empNum;
	private String ename;
	private int deptno;
	private int salary;
	
	public Employee() {}

	public Employee(int empNum, String ename, int deptno, int salary) {
		super();
		this.empNum = empNum;
		this.ename = ename;
		this.deptno = deptno;
		this.salary = salary;
	}
	public int getNum() {
		return empNum;
	}
	public void setNum(int empNum) {
		this.empNum = empNum;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empNum=" + empNum + ", ename=" + ename + ", deptno=" + deptno + ", salary=" + salary + "]";
	}
	
	

	
}
