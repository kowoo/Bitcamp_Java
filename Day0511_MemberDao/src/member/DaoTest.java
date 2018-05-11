package member;

import java.util.List;

public class DaoTest {
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		Member member = new Member();
		member.setNum(5);
		member.setId("nate");
		member.setPw("com");
		member.setName("네이트");
		member.setEmail("@nate.com");
		member.setRegdate("2018-03-27");
//		System.out.println("멤버 제작 성공");
		
		dao.insertMember(member);
		//dao.updateMember(member);
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
