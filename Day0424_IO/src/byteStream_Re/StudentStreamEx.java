package byteStream_Re;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

public class StudentStreamEx {
	public static void main(String[] args) {
		//student.txt 파일에 저장되어있는 문자열 읽어온 뒤
		//구분자로 구분하고, 데이터를 학생 객체에 넣기
		//FileInput/Output Stream
		//Student 객체, StringBuilder, StringTokenizer
		FileInputStream in = null;
		FileOutputStream out = null;
		StringBuilder sb = new StringBuilder();

		try {
			in = new FileInputStream("src/student.txt");
			int data;
			while((data = in.read()) != -1) {
				//읽어온 문자를 문자열로 만들어야함
				sb.append((char)data); //data에 들어있는 값을 하나하나 입력. 그냥 입력하면 숫자만 들어가므로 char로 변환한다.			
			}
			//while문이 끝나면 파일에 있는 문자열이 그대로 sb에 저장된다.
			String str = sb.toString(); // 스트링토크나이저를 하기 위해 char타입을 스트링으로 바꿔줌
			//제대로 읽어왔는지 확인
			//System.out.println(str);

			//읽어온 문자열을 '/' 기준으로 잘라내자!
			StringTokenizer st = new StringTokenizer(str, "/");

			//첫번째 토큰은 이름, 두번째는 학년, 세번째는 점수
			Student student = new Student(); //학생 객체를 만들고
			student.setName(st.nextToken()); //첫번째 토큰을 이름에 저장
			int grade = Integer.parseInt(st.nextToken()); //스트링 타입인 st.nextToken()을 인트로 바꿔주는 작업....
			student.setGrade(grade); //두번째 토큰을 점수에 저장
			int score = Integer.parseInt(st.nextToken()); //마찬가지로 int로 타입변환
			student.setScore(score); //세번째 토큰을 점수에 저장

			//파일로부터 읽어온 정보를 넣은 학생 객체의 정보를 출력
			System.out.println(student);

			//학생 정보 변경
			student.setName("lee");
			student.setGrade(2);
			student.setScore(100);

			//학생정보를 가져와서 문자열로 만들기
			String outStr= student.getName()+"/"+student.getGrade()+"/"+student.getScore();
			//System.out.println(outStr); 제대로 만들어졌는지 확인

			//학생정보를 file에 쓰기
			out = new FileOutputStream("src/studentOut.txt");
			out.write(outStr.getBytes());

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없어요!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
