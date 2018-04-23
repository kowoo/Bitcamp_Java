import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		//정올 실력키우기 1291 구구단 출력하기

		//		for(int i =1; i<=9; i++) {
		//			for(int j=2; j<=4; j++) {
		//				System.out.printf("%d * %d = %2d   ", j, i, j*i);
		//			}
		//		}

		Scanner input = new Scanner(System.in);
		int s;
		int e;

		s = input.nextInt();
		e = input.nextInt();

		while(true) {
			if((s>=2 && s<=9)&&(e>=2 && e<=9)) {
				break;
			} else {
				System.out.println("INPUT ERROR!");
				s = input.nextInt();
				e = input.nextInt();
			}
		}

		if(s<=e) {
			for(int i=1; i<=9; i++) {
				for(int j=s; j<=e; j++) {
					System.out.printf("%d * %d = %2d   ", j, i, j*i);
				}
				System.out.println();
			}
		} else {
			for(int i=1; i<=9; i++) {
				for(int j=s; j>=e; j--) {
					System.out.printf("%d * %d = %2d   ", j, i, j*i);
				}
				System.out.println();
			}
		}




	}

}
