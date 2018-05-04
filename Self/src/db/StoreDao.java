package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class StoreDao {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "kwh";
	private static final String PASSWORD = "1";
	private Connection conn=null;
	private Statement stmt=null;
	
	public StoreDao() {		
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
	
	public void insertStudent(Store store) {
		//praparedStatement: sql을 좀 더 쉽게 작성할 수 있게 만들어놓은 statement
		String sql = "insert into store"
				+ " values (?,?,?,?,?,?)"; //칼럼의 개수 만큼
		PreparedStatement pstmt=null;

		try {
			//preparedStatement 객체를 만들 때 템플릿을 줘야한다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, store.getName());
			pstmt.setString(2, store.getType());
			pstmt.setString(3, store.getTeleNumber());
			pstmt.setString(4, store.getOpenClosed());
			pstmt.setString(5, store.getPrice());
			pstmt.setString(6, store.getScore());
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
	
	public void updateStudent(Store store) {
		String sql = "update store values (?,?,?,?,?,?)";
		PreparedStatement pstmt=null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, store.getName());
			pstmt.setString(2, store.getType());
			pstmt.setString(3, store.getTeleNumber());
			pstmt.setString(4, store.getOpenClosed());
			pstmt.setString(5, store.getPrice());
			pstmt.setString(6, store.getScore());
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
	
	public void deleteStudent(String name) {
		String sql = "delete from store"
				+ " where name = "+name;
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
	
	public Store selectOne(String name) { //데이터를 전달하기위해 객체가 필요함.
		Store result=null;
		String sql = "select * from store"
				+ " where name = "+name;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			result = new Store();
			if(rs.next()) {
				//
				String sname;
				String type;
				String tele;
				String openclose;
				String price;
				String score;
				
				sname = rs.getString("name");
				type = rs.getString("type");
				tele = rs.getString("tele");
				openclose = rs.getString("openclose");
				price = rs.getString("price");
				score = rs.getString("score");
				result.setName(sname);
				result.setType(type);
				result.setTeleNumber(tele);
				result.setOpenClosed(openclose);
				result.setPrice(price);
				result.setScore(score);
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
	
	public Vector<Store> selectAll() {
		Vector<Store> result = new Vector<Store>();
		String sql = "select * from store";
		Statement stmt=null;
		ResultSet rs=null;	
		try {
			stmt = conn.createStatement();
			//결과 받아오기
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Store store = new Store(); //얘가 while문 바깥에 있으면 객체가 계속 덮어씌워져서 결과값으로 동일한 객체가 중복돼서 출력되어 버린다.
				//칼럼 이름으로도 가져올 수 있다.
				//이름으로 ResultSet에서 가져와서, 학생 객체에 넣기
				store.setName(rs.getString("name"));
				store.setType(rs.getString("type"));
				store.setTeleNumber(rs.getString("tele"));
				store.setOpenClosed(rs.getString("openclose"));
				store.setPrice(rs.getString("price"));
				store.setScore(rs.getString("score"));

				result.add(store);
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
