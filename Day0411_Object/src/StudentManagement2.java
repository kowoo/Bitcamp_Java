import java.util.Scanner;

public class StudentManagement2 {
	//1과 다른점: 기본값으로 4명이 들어가 있음
	Scanner sc = new Scanner(System.in);
	private Student[] students;
	private boolean isRun;
	private int count;

	public StudentManagement2() {
		students = new Student[50];
		isRun = true;
		count = 0;
		setDefaultData();
	}
	
	public void setDefaultData() {
		students[0] = new Student("홍길동", 3 , 100, 100, 90);
		students[1] = new Student("홍기동", 2 , 80, 100, 100);
		students[2] = new Student("홍길금", 1 , 100, 80, 100);
		students[3] = new Student("홍길은", 6 , 100, 100, 80);
		count+=4;
	}

	public void start() {
		while (isRun) {
			System.out.println("학생 관리 프로그램 입니다, 번호를 선택하세요");
			System.out.println("1.학생 목록		2.학생 추가		3.학생 검색		4.학생 삭제		5.종료");
			int select = sc.nextInt();
			sc.nextLine();
			switch (select) {
			case 1:
				System.out.println("학생 목록을 선택하셨습니다.");
				sList();
				break;
			case 2:
				System.out.println("학생 추가를 선택하셨습니다.");
				sPlus();
				break;
			case 3:
				System.out.println("학생 검색을 선택하셨습니다.");
				sSearch();
				break;
			case 4:
				System.out.println("학생 삭제를 선택하셨습니다.");
				sDelete();
				break;
			case 5:
				System.out.println("종료 합니다.");
				isRun = false;
				break;
			}
		}
	}

	public void sList() {
		for (int i=0; i<count; i++) {
			if(students[i].getGrade()!=0) {
			System.out.println(students[i]);
			}
		}
	}

	public void sPlus() {
//
//		if(count == students.length) { //배열 확장인데 다음에 시도해보자...
//			Student[] tmpStudents = new Student[count*2];
//			tmpStudents = students;
//		}
		System.out.println("이름을 입력해주세요.");
		String name = sc.nextLine();
		System.out.println("학년을 입력해주세요.");
		int grade = sc.nextInt();
		System.out.println("국어 점수를 입력해주세요.");
		int kor = sc.nextInt();
		System.out.println("영어 점수를 입력해주세요.");
		int eng = sc.nextInt();
		System.out.println("수학 점수를 입력해주세요.");
		int math = sc.nextInt();
		sc.nextLine();

		students[count] = new Student(name, grade, kor, eng, math);
		count++;
	}

	public void sSearch() {
		System.out.println("학생 이름을 입력해주세요.");
		String one = sc.nextLine();
		int tmp=-1;
		for(int i=0; i<count; i++) {
			tmp=-1;
			if(students[i].getName().equals(one)) {
				tmp = i;
			}
			if(tmp!=-1) {
				System.out.println(students[tmp]);
			}
		}
	}

	public void sDelete() {
		System.out.println("삭제할 학생의 이름을 입력해주세요.");
		System.out.println("이름이 같은 경우 나중에 입력된 학생이 삭제됩니다.");
		String sDel = sc.nextLine();
		int tmp=0;
		for(int i=0; i<count; i++) {
			if(students[i].getName().equals(sDel)) {
				tmp = i;
			}
		}
		for(int i=tmp; i<students.length-1; i++) {
			students[i] = students[i+1];
		}
		students[count] = null;
		count--;
	}

}
