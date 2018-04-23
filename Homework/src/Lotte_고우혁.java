import java.util.Random;

public class Lotte_고우혁 {
	public static void main(String[] args) {
		//1~45까지의 정수 중에 **중복되지 않는** 정수 6개를 생성
		//크기 6인 정수형 배열에 수를 저장하여 출력
		//배열, 중첩반복문 사용
		
		
		//1. 정수 6개를 저장할 배열을 만든다. 						-> 배열 선언
		//2. 정수 1~45의 범위값을 가진 랜덤 숫자를 생성하는 방법은? 		-> 랜덤 클래스
		//3. 생성된 난수가 이전에 생성된 수와 중복되지 않았는지 확인		-> if문을 사용. 하지만 반복을 해야하므로 for문도 필요함.
		//4. 중복되지 않았다면 배열에 저장한다.
		//5. 중복이 되었다면 3~4반복!
		//6. 그리고 다음 난수를 생성한다.
		//7. 이후 출력.
		
		Random ran = new Random(); // 난수 생성을 위한 랜덤 클래스
		int[] lotto = new int[6]; // 로또 번호 6개를 저장하기 위한 배열

		for(int i=0; i<lotto.length; i++) { // 로또 번호 생성을 위한 반복문
			lotto[i] = ran.nextInt(45)+1; // 번호 생성
			for(int j=0; j<i; j++) { // 두번째 숫자부터 이전 숫자와 중복이 되는지 확인
				if(lotto[i]==lotto[j]) { // 같다면
					i--; // 숫자 재생성을 위해 i-1
					break; // 종료
				}
			}
		}
		for(int i=0; i<lotto.length; i++) { //로또 번호가 저장된 배열을 출력
			System.out.println(lotto[i]);
		}
		
		
	
	}

}
