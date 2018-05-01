package object;

import java.util.Scanner;

public class StudentManage {
	StudentArray sList;
	private boolean isRun;
	Scanner sc;

	public StudentManage() {
		isRun=true;
		sc=new Scanner(System.in);
	}

	public void start() {
		System.out.println("학생관리 프로그램 입니다.");
		System.out.println("1. 학생 목록");
		System.out.println("2. 학생 추가");
		System.out.println("3. 학생 검색");
		System.out.println("4. 학생 삭제");
		System.out.println("5.   종료   ");
		System.out.print("번호를 선택해주세요 : ");
		int select = sc.nextInt();
		sc.nextLine();

		switch(select) {
		case 1: list(); break;
		case 2: add(); break;
		case 3: find(); break;
		case 4: del(); break;
		case 5: isRun = false; System.out.println("종료"); break;
		default: System.out.println("숫자 읽을줄 몰라?"); start(); 
		}
	}
	
	public void list() {
		if(sList.size()==0)	{
			System.out.println("학생이 없습니다.");
			return;
		} else {
			sList.printList(); 
		}
	}
	
	public void add() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		System.out.print("수학 : ");
		int math = sc.nextInt();
		sList.add(name, age, eng, math);
	}
	
	public void find() {
		System.out.print("찾고싶은 학생의 이름을 입력해주세요: ");
		String name = sc.nextLine();
		sList.find(name);
	}
	
	public void del() {
		System.out.print("삭제할 학생의 이름을 입력해주세요: ");
		String name = sc.nextLine();
		sList.dels(name);
	}

}
