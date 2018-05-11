package commons;

import java.util.HashMap;
import java.util.Map;

public class ConstantTest {
	public static void main(String[] args) {
		//Constant의 상수값들을 key로 해서 Map에 회원정보를 저장하는 예제
		
		Map<String, Object> member = new HashMap<String, Object>();
		//map에 넣을 때 이런 방식을 쓰자
		//member.put("id", "hong123");
		member.put(Constant.Member.ID, "hong123");
		member.put(Constant.Member.NAME, "홍길동");
		member.put(Constant.Member.EMAIL, "hong@email.com");
		member.put(Constant.Member.NUM, 123);
		member.put(Constant.Member.PW, "1234");
		
		System.out.println("아이디: "+member.get(Constant.Member.ID));
		System.out.println("이름: "+member.get(Constant.Member.NAME));
		System.out.println("이메일: "+member.get(Constant.Member.EMAIL));
	}
}
