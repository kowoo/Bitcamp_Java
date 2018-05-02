package employeeDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	private static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER="kwh";
	private static final String PASSWORD="1";
	private Connection conn=null;
	private Statement stmt=null;

	public EmployeeDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertEmployee(Employee emp) {
		String sql = "insert into employee"
				+ " values ("+emp.getNum()
				+ ",'"+emp.getEname()
				+ "',"+emp.getDeptno()
				+ ","+emp.getSalary()+")";
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
				if(stmt!=null)	stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateEmployee(Employee emp) {
		String sql = "update employee"
				+ " set ename='"+emp.getEname()+"',"
				+ "     deptno="+emp.getDeptno()+","
				+ "     salary="+emp.getSalary()
				+ " where enum="+emp.getNum();
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
				if(stmt!=null)	stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteEmployee(int empNum) {
		String sql = "delete from employee"
				+ " where enum="+empNum;
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
				if(stmt!=null)	stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public Employee selectOne(int empNum) {
		Employee result=null;
		String sql = "select * from employee"
				+ " where enum="+empNum;
		Statement stmt=null;
		ResultSet rs=null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			result = new Employee();
			if(rs.next()) {
				result.setNum(rs.getInt("enum"));
				result.setEname(rs.getString("ename"));
				result.setDeptno(rs.getInt("deptno"));
				result.setSalary(rs.getInt("salary"));
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

	public List<Employee> selectAll() {
		List<Employee> result = new ArrayList<Employee>();
		String sql = "select * from employee";
		Statement stmt=null;
		ResultSet rs=null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Employee emp = new Employee();
				
				emp.setNum(rs.getInt("enum"));
				emp.setEname(rs.getString("ename"));
				emp.setDeptno(rs.getInt("deptno"));
				emp.setSalary(rs.getInt("salary"));		
				result.add(emp);	
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
