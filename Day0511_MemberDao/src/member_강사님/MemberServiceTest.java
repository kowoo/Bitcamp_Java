package member_강사님;

public class MemberServiceTest {
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		MemberService service = new MemberService(dao);
		
//		boolean result = service.login("naver", "com");
//		if(result) {
//			System.out.println("로그인 성공");
//		} else {
//			System.out.println("로그인 실패");
//		}
		
		Member member = new Member();
		member.setId("ccc");
		member.setPw("net");
		member.setName("다음");
		member.setEmail("@daum.net");
		boolean loginS = service.join(member);

	}
	
}
