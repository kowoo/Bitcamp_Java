package dbtest;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {
	public static void main(String[] args) {
		//데이터베이스 프로그래밍 순서
		//1. 사용하고자 하는 DBMS에 맞는 드라이버 로딩
		//2. 연결생성(url, user, password)
		//	url:							포트	DB이름?
		//		jdbc:oracle:thin:@localhost:1521:XE
		//3. 구문객체를 생성(Statement)
		//	자바에서 작성한 sql을 DBMS로 전달하는 역할
		//4. SQL 작성 및 구문객체를 통한 실행
		//5. 결과 처리(데이터가 있으면 결과를 처리, 결과가 없는 질의의 경우 작업을 하지 않음)
		//	조회(select)의 경우에는 결과값을 봐야 하므로 데이터가 있는 셈.
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "kwh";
		String password = "1";
		
		//DBMS에 연결을 하게 되면 Connection 객체가 생성이 된다.
		Connection connection = null;
		
		//SQL을 작성해서 실행시키기 위해 구문 객체를 활용
		Statement stmt = null;
		
		
		//드라이버 로딩
		try {
			//로딩하고자 하는 드라이버 이름을 적어주면 된다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!");

			//Connection 객체는 DriverManager를 통해서 얻어올 수 있다.
			connection = DriverManager.getConnection(url, user, password); //커넥션을 이용해서 데이터를 주고 받는다. 소켓과 같은 개념
			System.out.println("SQL 연결 성공!");
			
			//SQL 전송은 연결을 통해서 전송하고 구문객체는 연결을 통해서 가져온다
			stmt = connection.createStatement();
			String sql = "insert into student_ex values (6,'홍길동',3)";
			
			//구문객체를 통해서 sql을 실행하는 메서드
			//executeUpdate, executeQuery, execute 를 주로 사용한다.
			//executeUpdate: insert, update, delete
			//executeQuery: select
			//execute: DDL (Data Definition Language)
			
			//영향을 받은 행의 개수를 반환.
			int rowCount = stmt.executeUpdate(sql);
			System.out.println(rowCount+"개의 행이 영향을 받았습니다.");
			
			
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("SQL 예외 발생");
		}
		
		
	}
}
