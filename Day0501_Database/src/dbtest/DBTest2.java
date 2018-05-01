package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest2 {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "kwh";
		String password = "1";
		
		Connection connection = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("SQL연결 성공!");
			
			
			stmt = connection.createStatement();
			String sql = "insert into student_ex values (4,'홍길동',3)";
			stmt.executeUpdate(sql);
			
			//stmt.executeQuery(sql);
			
		
		
		
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("드라이버 로딩 실패!!!");
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("SQL 연결 실패!!");
		}
	}
}
