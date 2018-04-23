package JavaLang;

import static java.lang.Math.*; // 이걸 넣으면 Math.max가 아니라 max만 해도 사용가능
public class JavaLangTest {
	public static void main(String[] args) {
		//String, Math 등
		//Wrapper Class : 기초자료형을 담을 수 있도록 만들어놓은 클래스
		//Byte, Short, Integer, Long
		//Float, Double, Character, Boolean
		
		//Math : 수학 연산과 관련된 기능을 가지고 있는 클래스
		//System.out.println(Math.max(3, 4)); // 두 수 중에서 큰 수를 반환함
		System.out.println("큰 값은: "+max(3, 4));
		System.out.println("작은 값은: "+min(3, 5));
		System.out.println("4의 제곱근: "+sqrt(4));
		System.out.println("4의 제곱: "+pow(4, 2));
		System.out.println("PI: "+ PI);
		System.out.println("-4의 절대값 : "+ abs(-4));
		
		//Wrapper 클래스 : 기초 자료형 데이터를 포함하는 클래스
		int x = 5;
		Integer number = new Integer(5);
		number = 5;
		
		if(number == 5) {
			System.out.println("같습니다.");
		}
		
		//System.out.println(number.compare(6, 5)); // compare(x, y) x가 크면 1반환, y가 크면 -1반환
		//문자열에서 숫자를 추출하기: parseInt(문자열)
		int a = Integer.parseInt("123")+1;
		System.out.println(Integer.parseInt("123") + 1);
		
		//---------------------------------------
		
		//StringBuilder : 문자열을 만들어주는 역할
		//				: 변경 가능한 문자열
		//String : 변경 불가능한 문자열
		//String str = new String("Hello");
		
		StringBuilder sb = new StringBuilder();
		//메서드체이닝기법 : 메서드의 반환형이 객체 자신이기 때문에 메서드 호출 후 다시 메서드를 호출 할 수 있다.
		sb.append("Hello").append("!!").append("@@");
		//sb.append("!!");
		
		String str = sb.toString();
		
		System.out.println(str);
		System.out.println(sb);
		
		String str1 = "Hello"; //상수영역 생성
		String str2 = new String("Hello"); //객체영역 생성
		
		if(str1 == str2) { //주소값 비교
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		if(str1.equals(str2)) { //문자 비교
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		//Object : 모든클래스의 조상 클래스
		//모든 클래스 is a Object
		//모든 객체는 Object 참조 변수에 참조 가능하다.
		Object o1 = 1;
//		Object o1 = new Integer(1); 둘이 같다
		Object o2 = "Hello";
		Object o3 = new TaekwonV();
		
		//toString()
		System.out.println(o3);
		
		
		
	}
}
