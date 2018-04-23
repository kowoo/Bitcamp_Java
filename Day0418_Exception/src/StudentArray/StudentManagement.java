package StudentArray;
import java.util.Scanner;
import java.util.InputMismatchException;
public class StudentManagement {
	// 학생관리 : 모든학생정보조회, 학생추가, 검색, 종료
	// 메뉴보여주기, 메뉴입력받기(입력받은 메뉴별로 기능수행)
	// 필요데이터 : 학생의 배열(Student[])

	private Student[] students; // 학생정보 저장을 위한 배열
	private boolean isRun; // 프로그램을 계속 실행할 것인지 확인하는 변수
	private Scanner scan;

	private int number; // 학생수를 카운트 하기 위한 변수

	public StudentManagement() {
		students = new Student[50];
		// isRun의 초기값을 true로 줘서 프로그램이 실행될 수 있도록 한다.
		isRun = true;
		scan = new Scanner(System.in);
		// 임의의 데이터 넣어주기
		setDefaultData();
	}

	public void start() {
		// 메뉴를 계속해서 출력하기 위해서 while문에서 메뉴를 출력한다.
		while (isRun) {
			showMenu();
			inputMenu();
		}
	}

	// 메뉴 보여주기
	public void showMenu() {
		System.out.println("***************************");
		System.out.println("******** 메뉴를 선택 하세요 *******");
		System.out.println("*                         *");
		System.out.println("* 1. 모든학생보기         2.학생정보입력 *");
		System.out.println("* 3. 이름검색               4. 종료          *");
		System.out.println("***************************");
		System.out.println("***************************");
	}

	// 메뉴 입력받기
	public void inputMenu() {
		scan = new Scanner(System.in);
		int menu = scan.nextInt();

		switch (menu) {
		case 1:
			// 학생정보보기
			showStudents();
			break;
		case 2:
			// 학생정보입력
			inputStudent();
			break;
		case 3:
			// 이름검색
			searchStudent();
			break;
		case 4:
			// 종료
			System.out.println("종료합니다.");
			isRun = false; // 프로그램을 종료하기 위해서 상태값을 false로 변경
			break;
		default:
			// 메뉴 없음
			System.out.println("잘못입력하셨습니다.");
			break;
		}
	}

	// 모든 학생 정보 보기 메서드
	public void showStudents() {
		System.out.println("학생정보보기");
		// 현재 내가 가지고있는 학생 정보를 모두 출력
		// 배열에 학생정보를 가지고 있다.
		// 배열의 요소를 하나 씩 출력
		for (int i = 0; i < number; i++) {
			// 배열요소에 접근하기 배열이름[index]
			// students[i] >> Student 객체 하나를 참조할 수 있음
			// System.out.println("이름 : " + students[i].getName());
			// System.out.println("학년 : " + students[i].getGrade());
			// System.out.println("평균 : " + students[i].getAverage());
			// System.out.println("점수: " + students[i].getScore());
			// System.out.println("--------------------------------");
			// System.out.println(students[i]);
			printStudent(i);

		}

	}

	public void printStudent(int index) {
		System.out.println("이름 : " + students[index].getName());
		System.out.println("학년 : " + students[index].getGrade());
		System.out.println("평균 : " + students[index].getAverage());
		System.out.println("점수: " + students[index].getScore());
		System.out.println("--------------------------------");
	}

// 학생 정보 입력하기 메서드
	public void inputStudent() {
//		try {
			System.out.println("학생정보 입력하기");
			// 학생의 정보를 사용자(키보드)로부터 입력받고
			// 객체를 만들어서 배열에 저장
			// 숫자를 입력받는 부분에서 예외가 발생하면
			// 1을 강제로 입력해 준다.

			System.out.println("이름을 입력하세요");
			String name = scan.next();

			System.out.println("학년을 입력하세요");
			int grade = 0;
			try{
				grade = scan.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("숫자를 입력하세요.1로 초기화 됩니다.");
				grade = 1;
				scan.next();
			}
			int kor =0;
			System.out.println("국어 점수를 입력하세요");
//			try{
				kor = scan.nextInt();
//			}catch(Exception e) {
//				System.out.println("???????");
//				e.printStackTrace();
//			}

			System.out.println("영어 점수를 입력하세요");
			int eng = scan.nextInt();

			System.out.println("수학 점수를 입력하세요");
			int math = scan.nextInt();

			// 객체를 만들어서 배열에다가 넣기
			students[number] = new Student(name, grade, kor, eng, math);
			number++;
			System.out.println("추가되었습니다.");
//		} catch (InputMismatchException e) {
//			/* e.printStackTrace(); */
//			System.out.println("잘못입력하셨습니다.");
//			return;
//		}
	}

	// 학생 정보 이름검색 메서드
	public void searchStudent() {
		// System.out.println("학생정보 검색하기");
		// 이름검색
		// 사용자에게 문자열을 입력받아서 해당 문자열을 포함하는 이름을 가진
		// 학생을 모두출력
		// 문자열을 하나 입력받고
		// 내가 가진 학생배열을 하나씩 검색하면서,
		// 입력받은 문자열과 이름을 비교해서 같거나, 문자열을 포함하고 있으면
		// 학생정보를 출력
		System.out.println("이름을 입력하세요");
		String keyword = scan.next();

		for (int i = 0; i < number; i++) {
			// students[i].getName()와 keyword 비교

			String name = students[i].getName();
			// 문자열 비교 : equals(), contains(s)
			// name.equals(keyword);
			// name 문자열이 keyword를 포함하고 있으면 true, 아니면 false
			// name.contains(keyword);

			if (name.contains(keyword)) {
				// 이름이 검색어를 포함하고 있다.
				// 해당학생을 출력
				// System.out.println("이름 : " + students[i].getName());
				// System.out.println("학년 : " + students[i].getGrade());
				// System.out.println("평균 : " + students[i].getAverage());
				// System.out.println("점수: " + students[i].getScore());
				// System.out.println("--------------------------------");
				printStudent(i);
			}

		}

	}

	// 임의의 학생정보를 배열에 넣어주는 임시메서드
	public void setDefaultData() {
		// 학생배열에 3~4명정도 학생정보 넣기
		students[0] = new Student("홍길동", 3, 100, 0, 50);
		students[1] = new Student("이순신", 2, 50, 100, 50);
		students[2] = new Student("신사임당", 1, 80, 100, 100);
		students[3] = new Student("김장금", 2, 70, 80, 100);
		number = 4;
	}
}
