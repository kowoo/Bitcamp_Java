package commons;

import java.util.HashMap;
import java.util.Map;

public class EnumTest {
	public static void main(String[] args) {
		System.out.println(Member.ID.getCol());
		System.out.println(Member.REG_DATE.getCol());
		
		Member e1 = Member.ID;
		
		//enum을 통해 명확한 값들만 사용 가능. 이상한건 못넣게
		//Member e2 = "123";
		
		Map<Member, Object> map = new HashMap<Member, Object>();
		map.put(Member.ID, "123");
		
	}
}