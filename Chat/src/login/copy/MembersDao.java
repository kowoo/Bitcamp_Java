package login.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MembersDao {
	Connection connection;

	public void insertMember(Members member) {
		PreparedStatement pstmt = null;
		try {
			connection = ConnectionProvider.getConnection();
			String sql = "insert into members values(?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getNick());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
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
	public Members selectOne(String id) {
		PreparedStatement pstmt = null;
		Members member = null;
		String sql = "select * from members where id="+id;
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
	public List<Members> selectAll() {
		PreparedStatement pstmt = null;
		String sql = "select * from members";
		ResultSet rs = null;
		List<Members> memberList = null;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			memberList = new ArrayList<Members>();
			while(rs.next()) {
				Members m = new Members();
				m.setId(rs.getString("id"));
				m.setPw(rs.getString("pw"));
				m.setNick(rs.getString("nick"));
				memberList.add(m);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return memberList;
	}
	public void deleteMember(int id) {
		PreparedStatement pstmt = null;
		String sql = "delete from members where id="+id;

		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}