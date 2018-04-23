import java.util.Scanner;

public class LoopEx {
	public static void main(String[] args) {
		/* 피보나치 수열 만들기
		 * 사용자로부터 정수 하나를 입력받아서 수 만큼의 피보나치 수열을 출력
		 * 0 1 1 2 3 5 8 13 21 34 55 . . .
		 * 
		 * n1 + n2 = n3
		 * 0 + 1 = 1
		 * 1 + 1 = 2
		 * 1 + 2 = 3
		 * 2 + 3 = 5
		 * 3 + 5 = 8
		 * 8 + 5 = 13
		 * 8 + 13 = 21 
		 * .
		 * .
		 * 단, 1항과 2항은 0과 1로 고정 (쉽게 하기 위함. 가능할거 같으면 고정안하고 해보자?)
		 */

		/* 1. 스캐너 클래스 선언, 입력받을 정수 변수 1개 입력
		 * 2. 반복문에 사용될 정수 변수 2개 사용
		 * 3. 브레이크문을 위한 조건문 사용
		 */
		Scanner input = new Scanner(System.in);
		int n1 = 0;
		int n2 = 1;
		int n3;
		System.out.println("출력할 항의 개수를 입력하세요.");
		int num = input.nextInt();

		//for문 2개 사용
		for(int i=0; i<num&&i<2; i++) {
			System.out.print(i+" ");
		}
		for(int j=3; j<=num; j++) {
			n3=n1+n2;
			n1=n2;
			n2=n3;
			System.out.print(n3+" ");
		}
		System.out.println();	
		
		//for문 1개 사용
		n1 = 0;
		n2 = 1;
		n3 = 0;	
		for(int k=1; k<=num; k++) {
			n3=n1+n2;
			System.out.print(n1+" ");
			n1=n2;
			n2=n3;
		}
		System.out.println();
		
		//강사님이 작성한 답안
		int n4,n5,n6; // 1, 2, 3인데 중복되므로 4~
		n4 = 0;
		n5 = 1;
		n6 = 0;
		//System.out.println(n4 + " " + n5 + " ");
		/*********************반복되는 부분***********************/
		//n3 = n1 + n2;
		//System.out.println(n6 + " ");
		/****************************************************/
		
		//n3 = n1 + n2;
		//System.out.println(n3 + " ");
		
		for(int i=1;i<=num;i++) {
			n6 = n4 + n5;
			System.out.print(n4 + " ");
			n4 = n5;
			n5 = n6;
		}
		
	}

}
