import java.util.Random;
public class Lotte_로또2 {
	
	public static void main(String[] args) {
	/* 로또 만들기 (배열)
	 * 조건
	 * 1. 1~45의 정수가 오도록 해야함.
	 * 2. 각 숫자들은 중복되면 안됨.		
	 * 3. 중복되면 해당 순서 난수 새로 생성.
	 * 4. 중복되지 않으면 저장
	 * 5. 2~4반복
	 * 6. 출력
	*/	
		
	// 1. 정수 배열, 난수 생성 클래스, 반복실행, 중복검사, 출력 필요
	// 2. int[] array, for, random, if, for ㄱㄱ
		
		int[] lotto = new int[6];
		
		Random ran = new Random();
		
		for(int i=0; i<6; i++) {
			lotto[i] = ran.nextInt(45)+1;
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}
			}
		}
		for(int i=0; i<6; i++) {
			System.out.println(lotto[i]);
		}
		
		
		
		
	}
	
}
