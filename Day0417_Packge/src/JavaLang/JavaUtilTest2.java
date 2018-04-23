package JavaLang;

import java.util.StringTokenizer;
public class JavaUtilTest2 {
	public static void main(String[] args) {
		//StringTokenizer
		//문자열을 특정한 문자 기준으로 잘라주는 역할을 가진 클래스
		String member = "홍길동/123@/hong123/hong@email.com";
		StringTokenizer tokenizer = new StringTokenizer(member, "/"); //멤버라는 녀석을 / 기준으로 자른다는 뜻.
		
		String name = tokenizer.nextToken();
		String pw = tokenizer.nextToken();
		String id = tokenizer.nextToken();
		String email = tokenizer.nextToken();
		
		System.out.println("이      름 : "+name);
		System.out.println("비밀번호 : "+pw);
		System.out.println("아 이  디 : "+id);
		System.out.println("메      일 : "+email);
	
		String data = "data1/data2/data3/data4/data5/data6/data7/data8";
		
		StringTokenizer st = new StringTokenizer(data, "/");
		while(st.hasMoreTokens()) { // 토큰이 더 있다면 트루!
			String str = st.nextToken();
			System.out.println(str);
		}
		
	}
}
