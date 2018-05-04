import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Daodao {
	private static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER="kwh";
	private static final String PASSWORD="1";
	private Connection conn=null;
	private Statement stmt=null;

	Daodao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int insert(Student s) {
		String sql = "insert into student_ex values(?,?,?)";
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s.getSnum());
			pstmt.setString(2, s.getSname());
			pstmt.setInt(3, s.getSgrade());
			result = pstmt.executeUpdate();	
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
		return result;
	}

	public int update(Student s) {
		String sql = "update student_ex set "
				+ " sname = '"+s.getSname()+"'"
				+ " sgrade = "+s.getSgrade()
				+ " where snum = "+s.getSnum();
		Statement stmt=null;
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

	public int delete(int snum) {
		String sql = "delete from student_ex"
				+ " where snum = "+snum;
		int result=0;
		Statement stmt=null;

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

	public Student selectOne(int snum) {
		String sql = "select * from student_ex "
				+ " where snum = "+snum;
		Student result=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			result = new Student();
			
			while(rs.next()) {
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
		List<Student> sList = new ArrayList<Student>();

		return sList;
	}

}
