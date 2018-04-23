import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagement {
	Scanner input = new Scanner(System.in);
	private Student[] student;
	private int num;
	private boolean isRun;

	public StudentManagement() {
		student = new Student[50];
		num = 0;
		isRun = true;
	}

	public void start() {
		System.out.println("1.학생 정보보기   2.학생 정보추가   3.학생 검색(번호) 4.학생 삭제(번호) 5. 종료");
		System.out.println("메뉴를 선택하세요");
		while(isRun) {
			try {
				int menu = input.nextInt();
				input.nextLine();
				switch(menu) {
				case 1:
					System.out.println("학생 정보보기를 선택하셨습니다.");
					sInfo();
					break;
				case 2:
					System.out.println("학생 정보추가를 선택하셨습니다.");
					sCreate();
					break;
				case 3:
					System.out.println("학생 검색을 선택하셨습니다.");
					sSearch();
					break;
				case 4:
					System.out.println("학생 삭제를 선택하셨습니다.");
					sDelete();
					break;
				case 5:	//5번 종료
					System.out.println("종료");
					isRun = false;
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
					start();
					break;
				}
			}catch(InputMismatchException e) {
				//e.printStackTrace();
				System.out.println("잘못입력하셨습니다.");
				input = new Scanner(System.in);
				return;
			}
		}
	}

	//1번 학생정보
	public void sInfo() {
		int count=0;
		for(int i=0; i<student.length; i++) {
			if(num==count) {
				break;
			}
			if(student[i]==null) {
				continue;
			} else {
				System.out.println(i+1+"번 "+this.student[i]);
				count++;
			}
		}
		System.out.println();
	}
	//2번 학생 추가
	public void sCreate() {
		try {
			System.out.println("학생 이름을 입력해주세요.");
			String name = input.nextLine();
			System.out.println("학생 번호를 입력해주세요.");
			num = input.nextInt();
			System.out.println("학년을 입력해주세요.");
			int grade = input.nextInt();
			System.out.println("국어 점수를 입력해주세요.");
			int kor = input.nextInt();
			System.out.println("영어 점수를 입력해주세요.");
			int eng = input.nextInt();
			System.out.println("수학 점수를 입력해주세요.");
			int math = input.nextInt();
			input.nextLine();

			student[num-1]=new Student(name, grade, kor, eng, math);
			this.num++;
		}catch(InputMismatchException e) {
			//e.printStackTrace();
			System.out.println("잘못입력하셨습니다.");
			input = new Scanner(System.in);
			start(); // 여기서 return;을 써도 같은 결과가 나온다.
		}
	}
	//3번 학생 검색
	public void sSearch() {
		try {
			System.out.println("학생 번호를 입력해주세요.");
			int number = input.nextInt();
			System.out.println(student[number-1]);
		}catch(InputMismatchException e) {
			//e.printStackTrace();
			System.out.println("잘못입력하셨습니다.");
			input = new Scanner(System.in);
			return;
		}
	}
	//4번 학생 삭제
	public void sDelete() {
		boolean ok=true;
		while(ok) {
			try {
				System.out.println("삭제할 학생의 번호를 입력해주세요.");
				int a = input.nextInt();
				input.nextLine();
				System.out.println("정말 삭제하시겠습니까? (Y/N)");
				char b = input.next().charAt(0);
				if(b=='Y'||b=='y') {
					student[a-1]=null;
					System.out.println("삭제가 완료되었습니다.");
					ok=false;
				}
			}catch(InputMismatchException e) {
				//e.printStackTrace();
				System.out.println("잘못입력하셨습니다.");
				input = new Scanner(System.in);
				return;
			}
		}
	}


}
