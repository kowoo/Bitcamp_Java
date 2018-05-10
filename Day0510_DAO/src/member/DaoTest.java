package member;

import java.util.List;

public class DaoTest {
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		Member member = new Member();
		member.setNum(3);
		member.setId("google");
		member.setPw("com");
		member.setName("구글");
		member.setEmail("@gmail.com");
		member.setRegdate("1991-12-02");
		System.out.println("멤버 제작 성공");
		
		dao.updateMember(member);
		//dao.insertMember(member);
		//dao.deleteMember(3);
		
//		Member tmp = new Member();
//		tmp = dao.selectOne(3);
//		System.out.println(tmp);
		
		List<Member> memberList = dao.selectAll();
		System.out.println(memberList.size());
		for(Member m: memberList) {
			System.out.println(m);
		}
		




	}
}
