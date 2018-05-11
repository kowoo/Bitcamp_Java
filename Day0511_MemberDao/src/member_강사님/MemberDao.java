package member_강사님;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import commons.Constant;

public class MemberDao implements IMemberDao{
	private Connection connection;

	//DB 프로그래밍 순서
	//드라이버로딩 - 연결생성 - 구문객체생성 및 sql 작성 - 구문객체를 통한 sql 실행  - 결과 처리


	@Override
	public int insertMember(Member member) {
		String sql = "insert into member values (member_seq.nextval,?,?,?,?,sysdate)";
		PreparedStatement pstmt=null;
		int result=0;
		try {
			connection = Connected.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			result = pstmt.executeUpdate();
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
		return result;
	}

	@Override
	public void updateMember(Member member) {
		String sql = "update member"
				+ "      set id    = ?,"
				+ "          pw    = ?,"
				+ "          name  = ?,"
				+ "          email = ?"
				+ "    where num   = ?";
		PreparedStatement pstmt = null;
		try {
			connection = Connected.getConnection();
			pstmt = connection.prepareStatement(sql);			
			//java.sql.Date 데이트는 java.util.Date를 상속받아서 만든 클래스이다.
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setInt(5, member.getNum());
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

	@Override
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
	
	@Override
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
//				mem = new Member();
//				mem.setNum(rs.getInt("num"));
//				mem.setId(rs.getString("id"));
//				mem.setPw(rs.getString("pw"));
//				mem.setName(rs.getString("name"));
//				mem.setEmail(rs.getString("email"));
//				mem.setRegdate(rs.getString("regdate"));
				
				mem = new Member();
				mem.setNum(rs.getInt(Constant.Member.NUM));
				mem.setId(rs.getString(Constant.Member.ID));
				mem.setPw(rs.getString(Constant.Member.PW));
				mem.setName(rs.getString(Constant.Member.NAME));
				mem.setEmail(rs.getString(Constant.Member.EMAIL));
				mem.setRegdate(rs.getString(Constant.Member.REG_DATE));
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
	
	@Override
	//로그인을 위한 조회로 id값을 받도록 만듦.
	public Member selectOneId(String id) {
		String sql = "select * from member where id = ?";
		Member mem = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			connection = Connected.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id); // sql을 ?로 넣을 경우 얘가 필요함.
			rs = pstmt.executeQuery();
			if(rs.next()) {
//				mem = new Member();
//				mem.setNum(rs.getInt("num"));
//				mem.setId(rs.getString("id"));
//				mem.setPw(rs.getString("pw"));
//				mem.setName(rs.getString("name"));
//				mem.setEmail(rs.getString("email"));
//				mem.setRegdate(rs.getString("regdate"));
				
				mem = new Member();
				mem.setNum(rs.getInt(Constant.Member.NUM));
				mem.setId(rs.getString(Constant.Member.ID));
				mem.setPw(rs.getString(Constant.Member.PW));
				mem.setName(rs.getString(Constant.Member.NAME));
				mem.setEmail(rs.getString(Constant.Member.EMAIL));
				mem.setRegdate(rs.getString(Constant.Member.REG_DATE));
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
	
	//로그인을 위한 조회로 pw값을 받도록 만듦.
	public Member selectOneEmail(String email) {
		String sql = "select * from member where email = ?";
		Member mem = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			connection = Connected.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, email); // sql을 ?로 넣을 경우 얘가 필요함.
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

	@Override
	public List<Member> selectAll() {
		String sql = "select * from member order by num";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = null;
		try {
			connection = Connected.getConnection();
			pstmt = connection.prepareStatement(sql);
			list = new ArrayList<Member>();
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member tmp = new Member();
				tmp.setNum(rs.getInt("num"));
				tmp.setId(rs.getString("id"));
				tmp.setPw(rs.getString("pw"));
				tmp.setName(rs.getString("name"));
				tmp.setEmail(rs.getString("email"));
				tmp.setRegdate(rs.getString("regdate"));
				list.add(tmp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}



}
