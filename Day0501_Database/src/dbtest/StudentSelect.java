package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentSelect {
	public static void main(String[] args) {
		//1. 드라이버 로딩
		//2. 연결
		//3. 구문객체 생성
		//4. sql 실행
		//5. 결과처리

		Connection conn=null; //Connection = 연결 객체
		Statement stmt=null; //Statement = 구문 객체, 둘다 트라이 위에서 생성하자.
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="kwh";
		String password="1";
		//쿼리의 결과값을 담고 있는 객체, 이번에 select를 썼으므로 미리 선언!
		ResultSet rs=null;

		try {
			//ClassNotFoundException 필요
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");

			//SQLException 필요, 연결: url, user, password
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("SQL연결 성공!");

			//구문 객체 생성
			stmt = conn.createStatement();

			//sql 작성: 번호가 6인 모든 학생의 정보 가져오기
			//			String sql = "select * from student_ex "
			//						+ "where snum=6";
			String sql = "select * from student_ex";

			//select 문장은 결과값이 있는 sql이므로 executeQuery을 사용한다.
			//executeQuery의 결과는 ResultSet에 저장된다.
			//ResultSet: 결과 데이터를 담고 있는 객체
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				//데이터가 있으면 진입
				int number = rs.getInt(1);
				String name = rs.getString(2);
				int grade = rs.getInt(3);
				System.out.println("-----------------------");
				System.out.println("번호: "+number);
				System.out.println("이름: "+name);
				System.out.println("학년: "+grade);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
