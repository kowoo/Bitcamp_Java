package student;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class StudentManagement {
	//Management 클래스에 학생정보를 저장하고 가져오는 기능을 추가.
	private static final String FILE_NAME = "sList.dat";
	private Scanner sc;
	private MyList<Student> sList;
	private boolean isRun;
	ObjectOutputStream oos=null;
	ObjectInputStream ois=null;

	public StudentManagement() {
		load();
		isRun = true;
		sc = new Scanner(System.in);
	}

	public void save() {
		//데이터를 파일에 저장하는 기능, 파일 출력		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(FILE_NAME)));
			
			//파일에 작성해야 하는 데이터>>>> sList
			oos.writeObject(sList);
			oos.flush();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try{
				if(oos !=null) oos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void load() {
		//파일로 부터 데이터를 불러오는 기능, 파일 입력
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(FILE_NAME)));
			try {
				sList= (MyList<Student>)ois.readObject();
			} catch(FileNotFoundException e) { //파일 낫파운드 익셉션을 위에 둔다.
				System.out.println("파일이 없습니다.");
				sList = new MyList<Student>(); //파일이 없을 경우 만들어주는 역할.
			} catch(IOException e) {
				e.printStackTrace();
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois!=null) ois.close();
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			} 
		}
	}

	public void start() {
		sc = new Scanner(System.in);
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
		System.out.println("이름을 입력하세요");
		String name = sc.next();
		System.out.println("학년을 입력하세요");
		int grade = 0;
		grade = sc.nextInt();
		int kor = 0;
		System.out.println("국어 점수를 입력하세요");
		kor = sc.nextInt();
		System.out.println("영어 점수를 입력하세요");
		int eng = sc.nextInt();
		System.out.println("수학 점수를 입력하세요");
		int math = sc.nextInt();
		// 객체를 만들어서 배열에다가 넣기
		Student s = new Student(name, grade, kor, eng, math);
		//만든 학생 객체를 StudentList의 객체에 넣어서 보관
		sList.add(s);
	}

	public void sSearch() {
		sc = new Scanner(System.in);
		System.out.println("학생 이름을 입력해주세요.");
		String one = sc.nextLine();
		for(int i=0; i<sList.size(); i++) {
			if(sList.get(i).getName().equals(one)) { // sList.get(i) = 학생 객체i, sList.get(i).getName() 학생 객체i의 이름
				System.out.println(sList.get(i));
			}
		}
		System.out.println();
	}

	public void sDelete() {
		//이름 입력받고, 해당하는 이름이 있는지 검색하고, 있으면 삭제
		if(sList.size()==0) {
			System.out.println("학생이 없습니다.");
			return;
		}
		String name = sc.next();
		//이름을 입력받아서 인덱스를 찾고, 인덱스를 sList.remove()
		//파라미터로 넘겨줌
		//인덱스 찾아서 파라미터로 넘겨줌,반복종료
		for(int i=0;i<sList.size();i++) {

			Student tmpStudent = sList.get(i);
			String studentName = tmpStudent.getName();
			if(studentName.equals(name)) {
				sList.remove(i);
				break;
			}
		}
	}

}
