package byteStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamEx {
	//데이터처리 스트림 예제3
	//객체단위로 데이터를 쓸 수 있게 만들어놓은 스트림
	//ObjectIntStream, ObjectOutStream
	
	//serialized(직렬화): 객체를 전송가능한 형태로 변경하는 것
	//전송하고자 하는 객체의 클래스에 직렬화를 구현
	
	
	public static void main(String[] args) {
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;

		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("student.dat")));
			Student s = new Student();
			s.setName("홍길동");
			s.setGrade(1);
			s.setScore(100);
		
			oos.writeObject(s);
			oos.flush();
			
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream("student.dat")));
			
			Student inputStudent = (Student)ois.readObject();
			System.out.println(inputStudent);

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
