package StudentArray;
import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentManagement3 {
	// 수정해야 할 부분: 입력받을 배열의 길이를 고정시키면 안됨
	// : 학생의 수만큼만 저장할 수 있는 배열을 관리

	private Student[] students; // 학생정보 저장을 위한 배열
	private boolean isRun; // 프로그램을 계속 실행할 것인지 확인하는 변수
	private Scanner scan;

	public StudentManagement3() {
		students = new Student[0];
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
		System.out.println("* 3. 이름검색              4. 삭제          *");
		System.out.println("* 5. 종료                                          *");
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
			//이름으로 삭제(처음검색된 학생만 삭제)
			deleteStudent();
			break;	
		case 5:
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

		for (int i = 0; i < students.length; i++) {
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
		try {
			System.out.println("학생정보 입력하기");
			// 학생의 정보를 사용자(키보드)로부터 입력받고
			// 객체를 만들어서 배열에 저장
			// 숫자를 입력받는 부분에서 예외가 발생하면
			// 1을 강제로 입력해 준다.

			System.out.println("이름을 입력하세요");
			String name = scan.next();

			System.out.println("학년을 입력하세요");
			int grade = 0;
			grade = scan.nextInt();
			int kor = 0;
			System.out.println("국어 점수를 입력하세요");

			kor = scan.nextInt();

			System.out.println("영어 점수를 입력하세요");
			int eng = scan.nextInt();

			System.out.println("수학 점수를 입력하세요");
			int math = scan.nextInt();

			// 객체를 만들어서 배열에다가 넣기
			 Student s = new Student(name, grade, kor, eng, math);

			// students[students.length] = s;
			 //			 number++;
			 //원래 배열크기보다  크기가 1큰 배열 만들고, 원래 배열 복사 한뒤,
			 //새로 만든 배열의 마지막칸에 새로운 객체 넣기
			 //[][][] students
			 //[][][][] tmpArr
			 Student[] tmpArr
			   = new Student[students.length+1];
			 for(int i =0;i<students.length;i++) {
				 tmpArr[i] = students[i];
			 }
			 tmpArr[students.length] = s;
			 
			 //관리할 배열 바꿔주기
			 students = tmpArr;
			 
			System.out.println("추가되었습니다.");
		} catch (InputMismatchException e) {
			/* e.printStackTrace(); */
			System.out.println("잘못입력하셨습니다.");
			return;
		}
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

		for (int i = 0; i < students.length; i++) {
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
	public void deleteStudent() {
		//이름 입력받고, 해당하는 이름이 있는지 검색하고, 있으면 삭제
		if(students.length ==0) {
			System.out.println("학생이 없습니다.");
			return;
		}
		
		String name = scan.next();
		boolean isDeleted = false; 
		//삭제할 학생을 찾아서, 복사를 하지 않았으면 true, 못찾았으면 false 
		Student[] tmpArr = new Student[students.length-1];
		int j=0;
		for(int i=0;i<students.length;i++) {
			//학생 이름이랑, 입력받은 이름이랑 같으면
			if(students[i].getName().equals(name)&&!isDeleted) {
				//삭제 하기 : 입력하기 반대
				//현재 배열보다 크기 1 작은 배열 생성
				//이름이 같은 첫번째 요소를 제외한 나머지 요소 모두 복사
				isDeleted = true;
			}else {
				//이름이 같지 않거나, 같더라도 이름이 같은  첫번째 요소가 아닐때 
				//새로운 배열에 원래 요소를 복사
				/*
				 * [ ][ ][v][ ][ ][ ]
				 * [ ][ ][ ][ ][ ]
				 * 찾기 전이랑, 찾고 나서 인덱스가 다름
				 * */
				tmpArr[j] = students[i];
				j++;
			}
		}
		students = tmpArr;
	}
	
	// 임의의 학생정보를 배열에 넣어주는 임시메서드
	public void setDefaultData() {
		// 학생배열에 3~4명정도 학생정보 넣기
		students = new Student[4];
		students[0] = new Student("홍길동", 3, 100, 0, 50);
		students[1] = new Student("이순신", 2, 50, 100, 50);
		students[2] = new Student("신사임당", 1, 80, 100, 100);
		students[3] = new Student("김장금", 2, 70, 80, 100);
	}
}
