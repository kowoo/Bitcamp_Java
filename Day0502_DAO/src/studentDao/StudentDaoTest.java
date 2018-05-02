package studentDao;

import java.util.List;

public class StudentDaoTest {
	public static void main(String[] args) {
		//StudentDAO 클래스 테스트(메서드 동작확인)
		StudentDao dao = new StudentDao();
		Student s = new Student();
		s.setSnum(8);
		s.setSgrade(1);
		s.setSname("두꺼비");
		
		//dao.insertStudent(s); // 정상 작동 확인
		
		//dao.updateStudent(s); // 정상 작동 확인
		
		//Student s1 = dao.selectOne(8);
		//System.out.println(s1); // 정상 작동 확인
		
		//dao.deleteStudent(8); // 정상 작동 확인
		
//		List<Student> sList = dao.selectAll(); // 정상 작동 확인
//		for(Student ss: sList) {
//			System.out.println(ss);
//		}
		
	}
}
