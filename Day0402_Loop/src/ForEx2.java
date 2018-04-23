import java.util.Scanner;

public class ForEx2 {
	public static void main(String[] args) {
		//누적합 구하기 for문으로 작성
		//양의 정수를 하나 입력받고 1부터 입력받은 정수까지의 누적합을 구하는 프로그램 작성
		
		//양의 정수를 입력받기 위해 정수타입 변수, 스캐너를 준비한다.
		//입력받은 수를 for문을 이용해서 누적합을 구한다.
		//입력 받은 뒤에 계산하므로 입력문은 for문 밖에다 놔도 될듯.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수를 입력하세요 : ");
		int a = sc.nextInt();
		int sum = 0;
		
		for (int b=1; b<=a; b++) {
			sum = sum + b;
		}
		System.out.println("1부터 "+ a+"까지의 누적 합은 "+ sum+"입니다.");
		
		
		
	}

}
