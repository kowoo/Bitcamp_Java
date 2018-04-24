package student;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentManagement {
	Scanner sc = new Scanner(System.in);
	private MyList<Student> sList;
	private boolean isRun;
	private int count;
	ObjectOutputStream oos=null;
	ObjectInputStream ois=null;

	//데이터처리 스트림 예제3
	//객체단위로 데이터를 쓸 수 있게 만들어놓은 스트림
	//ObjectIntStream, ObjectOutStream

	//serialized(직렬화): 객체를 전송가능한 형태로 변경하는 것
	//전송하고자 하는 객체의 클래스에 직렬화를 구현

//	public static void main(String[] args) {
//		
//	}

	public void save() {
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("sList.txt")));
			oos.writeObject(sList);
			oos.flush();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	public MyList<Student> load() {
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream("sList.txt")));
			sList = (MyList<Student>)ois.readObject();

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return sList;
	}


	public StudentManagement() {
		sList = new MyList<Student>();
		isRun = true;
		count = 0;
	}


	public void start() {
		sList = load();
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
				save();
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
		System.out.println("점수를 입력해주세요.");
		int score = sc.nextInt();
		sc.nextLine();

		sList.add(new Student(name, grade, score));
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
