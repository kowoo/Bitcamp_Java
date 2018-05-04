package studentDao2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	//속성값: 연결해야 되니까 url, user, password 필요함
	private static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER="kwh";
	private static final String PASSWORD="1";
	private Connection conn=null;
	private Statement stmt=null;

	//생성자에서 드라이버 로딩하고 연결까지 하기, 연결객체는 멤버변수로 유지.

	public StudentDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//연결을 위해서는 드라이버 매니저가 필요하다.
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			//구문객체는 연결을 통해 생성한다.
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertStudent(Student student) {
		//praparedStatement: sql을 좀 더 쉽게 작성할 수 있게 만들어놓은 statement
		String sql = "insert into student_ex"
				+ " values (?,?,?)"; //칼럼의 개수 만큼
		PreparedStatement pstmt=null;

		try {
			//preparedStatement 객체를 만들 때 템플릿을 줘야한다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getSnum());
			pstmt.setString(2, student.getSname());
			pstmt.setInt(3, student.getSgrade());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void updateStudent(Student student) {
		String sql = "update student_ex values (?,?,?)";
		PreparedStatement pstmt=null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getSnum());
			pstmt.setString(2, student.getSname());
			pstmt.setInt(3, student.getSgrade());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void deleteStudent(int snum) {
		String sql = "delete from student_ex"
				+ " where snum = "+snum;
		Statement stmt=null;

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Student selectOne(int snum) { //데이터를 전달하기위해 객체가 필요함.
		Student result=null;
		String sql = "select * from student_ex"
				+ " where snum = "+snum;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			result = new Student();
			if(rs.next()) {
				//
				int number;
				String sname;
				int sgrade;
				
				number = rs.getInt("snum");
				sname = rs.getString("sname");
				sgrade = rs.getInt("sgrade");
				result.setSnum(number);
				result.setSname(sname);
				result.setSgrade(sgrade);			
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return result;
	}
	
	public List<Student> selectAll() {
		List<Student> result = new ArrayList<Student>();
		String sql = "select * from student_ex";
		Statement stmt=null;
		ResultSet rs=null;	
		try {
			stmt = conn.createStatement();
			//결과 받아오기
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Student student = new Student(); //얘가 while문 바깥에 있으면 객체가 계속 덮어씌워져서 결과값으로 동일한 객체가 중복돼서 출력되어 버린다.
				//칼럼 이름으로도 가져올 수 있다.
				//이름으로 ResultSet에서 가져와서, 학생 객체에 넣기
				student.setSnum(rs.getInt("snum"));
				student.setSname(rs.getString("sname"));
				student.setSgrade(rs.getInt("sgrade"));

				result.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;	
	}
	

}
