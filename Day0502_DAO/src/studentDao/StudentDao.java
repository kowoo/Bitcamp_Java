package studentDao;

import java.sql.Connection;
import java.sql.DriverManager;
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

	//가지고 있어야하는 기능, insert, update, delete, select, selectAll
	public int insertStudent(Student student) {
		String sql = "insert into student_ex"
				+" values ("+student.getSnum()
				+ ",'"+student.getSname()
				+ "',"+student.getSgrade()+")";
		Statement stmt = null;
		int result=0;

		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
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
		return result;
	}

	public int updateStudent(Student student) {
		//테이블에 학생정보 얻어오기
		String sql = "update student_ex"
				+ " set sname = '"+student.getSname()+"',"
				+ "     sgrade = "+student.getSgrade()
				+ " where snum = "+student.getSnum();			
		Statement stmt=null;
		int result=0;

		try {
			//구문 객체 가져오기
			stmt = conn.createStatement();
			//실행
			result = stmt.executeUpdate(sql);

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
		return result;
	}

	public int deleteStudent(int snum) { //학생 번호로만 삭제하는 기능으로 만들자.
		//지금은 학생 번호도 중복이 되지만 나중에는 key를 통해 번호는 중복되지 않게 만들게 된다.
		//그렇기 때문에 snum을 사용. 왜? 이름은 동명이인, 학년은 같을 수 있지만 번호는 다르니까
		//where sum =+ snum
		String sql = "delete from student_ex"
				+ " where snum = "+snum;
		Statement stmt=null;
		int result=0;

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
		return result;
	}

	//select는 좀 할게 많다.
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
