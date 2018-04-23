package list2;
import java.util.Scanner;

public class StudentManagement2 {
	Scanner sc = new Scanner(System.in);
	private MyList<Student> sList;
	private boolean isRun;
	private int count;

	public StudentManagement2() {
		sList = new MyList<Student>();
		isRun = true;
		count = 0;
		setDefaultData();
	}
	
	public void setDefaultData() {
		sList.add(new Student("홍기동", 2 , 80, 100, 100));
		sList.add(new Student("홍길동", 3 , 100, 100, 90));
		sList.add(new Student("홍길금", 1 , 100, 80, 100));
		sList.add(new Student("홍길은", 6 , 100, 100, 80));
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
		for (int i=0; i<sList.size(); i++) {
			System.out.println(sList.get(i));
		}
		System.out.println();
	}

	public void sPlus() {
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

		sList.add(new Student(name, grade, kor, eng, math));
		System.out.println("학생이 추가되었습니다.");
		System.out.println();
	}

	public void sSearch() {
		System.out.println("학생 이름을 입력해주세요.");
		String one = sc.nextLine();
		for(int i=0; i<sList.size(); i++) {
			if(sList.get(i).getName().equals(one)) { // sList.get(i) = 학생 객체i, sList.get(i).getName() 학생 객체i의 이름
				System.out.println(sList.get(i));
			}
		}
		System.out.println();
	}

	//삭제기능 맛탱이 가버림.
	public void sDelete() {
		System.out.println("삭제할 학생의 이름을 입력해주세요.");
		System.out.println("이름이 같은 경우 먼저 입력된 학생이 삭제됩니다.");
		String sDel = sc.nextLine();
		for(int i=0; i<sList.size(); i++) {
			if(sList.get(i).getName().equals(sDel)) {
				System.out.println(sList.get(i));
				System.out.println("해당 학생이 삭제됩니다.");
				System.out.println();
				sList.remove(i);
				break;
			}
		}
	}

}
