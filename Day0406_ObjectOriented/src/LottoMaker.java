import java.util.Random;

public class LottoMaker {
	//기능 == 메서드, 상태값(데이터) == 변수
	int[] lotto = new int[6];
	public void makeNumber() {
		//난수를 만들어내고 출력
		System.out.println("숫자 만들고 출력");
		
		Random ran = new Random();

		for(int i=0; i<lotto.length; i++) {
			lotto[i] = ran.nextInt(45)+1;
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}
			}
		}
		for(int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i]+" ");
		}
			
	}
}
