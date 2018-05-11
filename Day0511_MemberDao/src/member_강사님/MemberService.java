package member_강사님;

public class MemberService {
	//로그인 기능: 성공하면 true반환, 실패하면 false반환
	//id, pw 입력받음 
	//1. DB에서 회원목록 조회
	//2-1. id가 없으면 로그인 실패 == return false
	//2-2. 있으면 3로 진행
	//3-1. pw가 일치하면 로그인 성공  == return true
	//3-2. 틀리면 로그인 실패  == return false
	
	private MemberDao dao;
	
	public MemberService(MemberDao dao) {
		this.dao = dao;
	}
	
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	public boolean login(String id, String pw) {
		//1. id가 있는지 없는지 검사
		boolean result = false;
		Member member = dao.selectOneId(id);
		if(member!=null) {
			//아이디가 있다는 뜻이니 pw비교
			if(member.getPw().equals(pw)) {
				//로그인 성공
				result = true;
				//각각 리턴으로 해도 됨. 그게 더 보기 좋으면 그걸로~
			} else {
				//pw가 틀렸으니 false
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}
	
	//join() 메서드 작성
	//회원정보를 파라미터로 받아와서 테이블에 넣기
	//join(Member): boolean
	//성공하면 true, 실패하면 false
	//1. 입력받은 회원정보를 이용하여 테이블 조회
	//2-1. 중복된 경우 회원가입 실패
	//2-2. 아닌 경우 회원가입 절차시작
	//3. insert했을 때 결과가 1이면 회원가입 성공, 0이면 실패
	
	public boolean join(Member member) {		
		Member id = dao.selectOneId(member.getId());
		if(id!=null) {
			System.out.println("이미 있는 아이디 입니다.");
			return false;
		} else {
			Member email = dao.selectOneEmail(member.getEmail());
			if(email!=null) {
				System.out.println("중복된 이메일 입니다.");
				return false;
			} else {
				dao.insertMember(member);
				System.out.println("회원가입 성공!");
				return true;
			}
		}
	}
}
