package lastChat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import login.ConnectionProvider;
import login.Members;

public class MemberDao {
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER="kwh";
	private final String PASSWORD="1";
	private Connection connection;
	
	public MemberDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(Member member) {
		String sql = "insert into members values(?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getNick());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public Member selectOne(String id) {
		String sql = "select * from members where id="+id;
		PreparedStatement pstmt = null;
		Member member = null;
		ResultSet rs = null;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setNick(rs.getString("nick"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	public Members checkNick(String nick) {
		PreparedStatement pstmt = null;
		Members member = null;
		String sql = "select * from members where nick="+nick;
		ResultSet rs = null;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Members();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setNick(rs.getString("nick"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public List<Member> selectAll() {
		return null;
	}
}
