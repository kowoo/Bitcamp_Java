import java.util.Scanner;

public class ArrayEx2 {

	public static void main(String[] args) {
		//학생의 점수를 입력받는 10칸짜리 배열 1개 생성
		//반복문을 이용하여 배열에 데이터를 입력한다
		//이후 출력한다
		/* 예) 
		 * 점수를 입력하세요.
		 * 50
		 * 점수를 입력하세요.
		 * 60
		 * 점수를 입력하세요.
		 * 70
		 * ... 10회 반복
		 * 
		 * 입력된 점수는
		 * 50 60 70 ...
		 * 
		 */
		
		//10회 반복이니 for문을 사용하자.
		//배열을 이용해야 하니 스코어는 배열에 저장.
		//출력을 위한 for문도 필요하다. 그러므로 for문은 총 2개
		
		Scanner sc = new Scanner(System.in);
		int[] scores = new int[10];
		
		for(int i=0; i<scores.length; i++) { //10회 반복해서 입력받기 위한 for문.
			System.out.println("점수를 입력하세요.");
			scores[i] = sc.nextInt(); //입력받은 값을 배열에 저장한다.
		}
			System.out.println("입력된 점수는");
		for(int j=0; j<scores.length; j++) { //입력한 값을 출력하기 위한 for문
			System.out.print(scores[j]+" "); //입력받은 값을 출력한다.
		}
		
		


	}
}
