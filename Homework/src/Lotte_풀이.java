//import java.util.Random;

public class Lotte_풀이 {
	public static void main(String[] args) {
		//1~45까지의 정수 중에 **중복되지 않는** 정수 6개를 생성
		//크기 6인 정수형 배열에 수를 저장하여 출력
		//배열, 중첩반복문 사용

		//발생한 로또번호 6개를 저장하기 위한 배열
		int[] lotto = new int[6];
		//1~45사이의 난수를 만드는 방법
		//(int)(Math.random()*45+1);
		//난수 만들고 나서 배열에다가 0번부터 5번까지 차례대로 저장
		//Random ran = new Random();
		int count=0;
		//숫자 생성 반복문
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random()*6+1);
			count++;
			//중복을 없애는 방법이 필요하다.
			//[31] [7] [15] [24] [x]
			//중복 검사 수행 반복문
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {
					//중복이 발생하면 실행됨
					//i번째 난수를 새로 만들어줘야한다
					i--;
					break;
				}
			}

		}
		//출력
		for(int num: lotto) { // for each
			System.out.print(num+" ");
		}
		System.out.println();
		System.out.println(count); //중복실행된 횟수를 출력.

	}

}
