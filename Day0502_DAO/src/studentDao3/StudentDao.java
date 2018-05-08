package studentDao3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	//기능을 하기 위해서 연결이 필요하다.
	Connection connection;
	//DBMS와의 연결은 외부 자원을 이용하는 것이기 때문에 계속해서 열어놓고 사용하면 누수가 발생한다.
	//사용할 때마다 연결을 만들어서 사용.

	//insert, update, delete, selectOne, selectAll
	public void insertStudent(Student stu) {
		PreparedStatement pstmt = null;
		try {
			//연결 얻어오기
			connection = ConnectionProvider.getConection();
			String sql = "insert into student_ex values(?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, stu.getSnum());
			pstmt.setString(2, stu.getSname());
			pstmt.setInt(3, stu.getSgrade());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(connection!=null) connection.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void updateStudent(Student student) {
		PreparedStatement pstmt=null;

		try {
			connection = ConnectionProvider.getConection();
			String sql = "update student_ex "
					+ "      set sname = ?,"
					+ "          sgrade = ?"
					+ "    where snum = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, student.getSname());
			pstmt.setInt(2, student.getSgrade());
			pstmt.setInt(3, student.getSnum());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(connection!=null) connection.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void deleteStudent(int snum) {
		PreparedStatement pstmt=null;

		try {			
			connection = ConnectionProvider.getConection();
			String sql = "delete from student_ex where snum = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, snum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(connection!=null) connection.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Student selectOne(int snum) {
		PreparedStatement pstmt=null;
		Student result=null;
		ResultSet rs=null;

		try {
			connection = ConnectionProvider.getConection();
			String sql = "select * from student_ex where snum = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, snum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new Student();
				result.setSnum(rs.getInt("snum"));
				result.setSname(rs.getString("sname"));
				result.setSgrade(rs.getInt("sgrade"));			
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(connection!=null) connection.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return result;
	}

	public List<Student> selectAll() {
		PreparedStatement pstmt=null;
		List<Student> result = new ArrayList<Student>();
		ResultSet rs=null;	

		try {
			connection = ConnectionProvider.getConection();
			String sql = "select * from student_ex";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setSnum(rs.getInt("snum"));
				student.setSname(rs.getString("sname"));
				student.setSgrade(rs.getInt("sgrade"));
				result.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(connection!=null) connection.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return result;	
	}

}
