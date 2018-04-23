import java.util.Scanner;

public class Practice_고우혁 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt(); //첫번째 숫자를 입력받음
		int e = sc.nextInt(); //두번째 숫자를 입력받음

		while(s<2||s>9||e<2||e>9) { // 두 숫자 중 하나라도 구구단의 범위를 벗어날 경우 경고문 출력
			System.out.println("INPUT ERROR!");
			s = sc.nextInt(); // 범위를 벗어난 숫자를 입력했으므로 재입력을 하게 만든다.
			e = sc.nextInt(); // while값이 false가 될 때까지 반복.
		}
		
		if(s<=e) { // e가 s보다 크거나 같을 경우
			for(int i=1; i<=9; i++) {
				for(int j=s; j<=e; j++) {
					System.out.printf("%d * %d = %2d   ", j, i, j*i); // %d가 아닌 %2d를 쓴 이유는 정렬을 위함.
				}
				System.out.println(); // 열 변경을 위해 사용
			}
		}else { // s가 클 경우
			for(int i=1; i<=9; i++) {
				for(int j=s; j>=e; j--) {
					System.out.printf("%d * %d = %2d   ", j, i, j*i);
				}
				System.out.println();
			}
		}
		//두 가지로 나눈 이유는 s-e가 마이너스일 경우 진행이 안되기 때문입니다.
	}
}