
public class StringEx2 {

	public static void main(String[] args) {
		//"no news is good news"
		//에서 반복문을 사용하여 문자 'n'의 개수를 출력하는 프로그램을 작성하자
		String str = "no news is good news";
		//예)
		//'n'의 개수는 3개 입니다.
		
		//반복문을 통해 str 문자열 내의 n의 개수를 저장한다.
		//n의 개수를 출력한다.
		//변수명.charAt(n)를 통해 해당 변수의 'n'번째 문자를 확인할 수 있다.
		//스트링을 캐릭터의 배열이라고 생각하고 접근하자.
		
		int countN=0;
		
		for(int i=0; i<str.length(); i++) {	
			if('n'==str.charAt(i)) {
				countN++;
			}
		}
		System.out.printf("'n' 의 개수는 %d개 입니다.", countN);
		
		
		
		
	}
	
}
