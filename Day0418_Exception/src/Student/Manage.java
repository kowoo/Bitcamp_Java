package Student;
import java.util.InputMismatchException;
import java.util.Scanner;

import StudentArray.StudentList;

public class Manage {
	List l;
	Student[] st;
	Scanner scan;
	boolean isRun;
	int numInput;
	
	
	public Manage() {
		scan=new Scanner(System.in);
		isRun=true;
		numInput=0;
		l=new List();
	}
	
	public void start() { //시작
		while(isRun) {
			try {
				System.out.println("■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■학생 관리 프로그램■■■");
				System.out.println("■■■1. 학생 목록.  ■■■");
				System.out.println("■■■2. 학생 등록.  ■■■");
				System.out.println("■■■3. 학생 검색.  ■■■");
				System.out.println("■■■4. 학생 제거.  ■■■");
				System.out.println("■■■5. 종       료.  ■■■");
				System.out.println("■■■■■■■■■■■■■■■■■■");
				System.out.print(": ");
				numInput = scan.nextInt();
				scan.nextLine();
			}catch(InputMismatchException e) {
				System.out.println("잘못입력하셨습니다.");
				scan = new Scanner(System.in);
				start();
			}
			select();
		}
	}
		
	public void select() { //선택
		switch(numInput) {
		case 1:
			sL();
			break;
		case 2:
			sC();
			break;
		case 3:
			sS();
			break;
		case 4:
			sD();
			break;
		default:
			System.out.println("종료종료종료종료종료종료종료");
			System.out.println("종료종료종료종료종료종료종료");
			System.out.println("종료종료종료종료종료종료종료");
			System.out.println("종료종료종료종료종료종료종료");
			System.out.println("종료종료종료종료종료종료종료");
			isRun = false;
		}
	}
	
	
	public void sL() { //목록
		st = l.getS();
		for(int i=0; i<st.length; i++) {
			System.out.println(st[i]);
		}
	}
	
	public void sC() { //추가
		try {
			System.out.println("학생 등록");
			System.out.print("이름 : ");
			String name = scan.nextLine();
			System.out.print("학년 : ");
			int grade = scan.nextInt();
			System.out.print("국어 : ");
			int kor = scan.nextInt();
			System.out.print("영어 : ");
			int eng = scan.nextInt();
			scan.nextLine();
			System.out.println("완료");
			System.out.println();
			Student tmp = new Student(name,grade,kor,eng);
			l.add(tmp);
		}catch(InputMismatchException e) {
			System.out.println("잘못입력하셨습니다.");
			scan = new Scanner(System.in);
			start();
		}
	}
	
	public void sS() { //검색
		st = l.getS();
		System.out.println("학생 검색");
		System.out.print("이름 : ");
		String name = scan.nextLine();
		for(int i=0; i<st.length; i++) {
			if(name.equals(st[i].getName())) {
				System.out.println(st[i]);
			}
		}
	}
	
	public void sD() { //삭제
		System.out.println("학생 제거");
		System.out.print("이름 : ");
		String name = scan.nextLine();
		l.del(name);
		System.out.println("삭제 완료");
	}
	
}
