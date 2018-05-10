package multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	//DBMS와의 연결을 제공해주는 클래스
	//필요한 기능: 연결 반환, 클래스 변수(상수 변수를 이용해서 같은 작업을 하기 때문에, 객체마다 생성될 이유가 없으므로 static선언)
	//연결 반환을 위해서는 연결을 만들어야하므로 URL, USER, PASSWORD가 필요함.
	private static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER="kwh";
	private static final String PASSWORD="1";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		//1. 드라이버 로딩
		//2. 연결 후 반환
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
