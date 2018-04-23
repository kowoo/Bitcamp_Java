
public class Student {
	//이름(문자열), 학년(정수), 번호(정수)
	//Student 객체가 할 수 있는 동작
	//상태값 출력 (프린트스튜던트)
	String name;
	int grade;
	int number;
	public void printStudent() {
		System.out.println("이름 : "+name);
		System.out.println("학년 : "+grade);
		System.out.println("번호 : "+number);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", number=" + number + "]";
	}

}
