package member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	private Connection connection;

	public void insertMember(Member member) {
		String sql = "insert into member (num,id,pw,name,email) values (?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			connection = Connected.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, member.getNum());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getName());
			pstmt.setString(5, member.getEmail());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
		System.out.println(member+ " 추가 완료.");
	}

	public void updateMember(Member member) {
		String sql = "update member"
				+ "      set id    = ?,"
				+ "          pw    = ?,"
				+ "          name  = ?,"
				+ "          email = ?,"
				+ "        regdate = ?"
				+ "    where num   = ?";
		PreparedStatement pstmt = null;
		try {
			connection = Connected.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setDate(5, Date.valueOf(member.getRegdate()));
			pstmt.setInt(6, member.getNum());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
		System.out.println(member+ " 수정 완료.");
	}

	public void deleteMember(int num) {
		String sql = "delete from member where num = "+num;
		PreparedStatement pstmt = null;
		try {
			connection = Connected.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
		System.out.println(num+ "번 삭제 완료.");
	}

	public Member selectOne(int num) {
		String sql = "select * from member where num = "+num;
		Member mem = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			connection = Connected.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				mem = new Member();
				mem.setNum(rs.getInt("num"));
				mem.setId(rs.getString("id"));
				mem.setPw(rs.getString("pw"));
				mem.setName(rs.getString("name"));
				mem.setEmail(rs.getString("email"));
				mem.setRegdate(rs.getString("regdate"));
			}		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
		return mem;
	}

	public List<Member> selectAll() {
		String sql = "select * from member order by num";
		List<Member> memberList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = Connected.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			memberList = new ArrayList<Member>();
			
			while(rs.next()) {
				Member tmp = new Member();
				tmp.setNum(rs.getInt("num"));
				tmp.setId(rs.getString("id"));
				tmp.setPw(rs.getString("pw"));
				tmp.setName(rs.getString("name"));
				tmp.setEmail(rs.getString("email"));
				tmp.setRegdate(rs.getString("regdate"));			
				memberList.add(tmp);
			}			 			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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




}
