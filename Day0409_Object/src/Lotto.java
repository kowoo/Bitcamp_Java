import java.util.Random;
public class Lotto {
	
	int[] lotto; // 로또 번호 6개를 저장하기 위한 배열
	
		// 배열을 받아서 lotto에 넣어줄 수 있는 생성자 1, 기본 생성자 1

	public Lotto() {
		//super; (다음에 배움)
		//매개변수가 없는 생성자 (기본 생성자)
		lotto = new int[6];
	}
	
	public Lotto(int[] arr) {
		lotto = arr;
	}
	
	
	public void makeNumber() {
		Random ran = new Random(); // 난수 생성을 위한 랜덤 클래스
		for(int i=0; i<lotto.length; i++) { // 로또 번호 생성을 위한 반복문
			lotto[i] = ran.nextInt(45)+1; // 번호 생성
			for(int j=0; j<i; j++) { // 두번째 숫자부터 이전 숫자와 중복이 되는지 확인
				if(lotto[i]==lotto[j]) { // 같다면
					i--; // 숫자 재생성을 위해 i-1
					break; // 종료
				}
			}
		}
	}
	
	public void sort() {
		int min=0;
		for(int i=0; i<lotto.length-1; i++) {
			for(int j=i; j<lotto.length; j++) {
				if(lotto[i]>lotto[j]) {
					min=lotto[j];
					lotto[j]=lotto[i];
					lotto[i]=min;
				}
			}
		}	
	}
	public void printLotto() {
		for(int num: lotto) { //로또 번호가 저장된 배열을 출력
			System.out.print(num+" ");
		}
		System.out.print('\n');
	}
	
}
