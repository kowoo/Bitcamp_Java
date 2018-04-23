import java.util.Scanner;

public class WhileEx {
	public static void main(String[] args) {
		// 예제. 1부터 10까지의 합을 출력하는 프로그램을 작성하라.
		// 단, while 문장을 사용한다.
		int sum, n, start;
		sum=0;
		start=1;
		n=start;
		while(n<=10) {
			sum+=n;
			++n;
		}
		System.out.printf("%d부터 %d까지의 합은 %d입니다.%n",start,n-1,sum);
		
		// 예제2. 사용자에게 입력받은 수 만큼 반복해서 더하기
		// 예) 숫자를 입력하세요.
		// 3
		// 1부터 3까지의 합은 6 입니다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요");
		int h = sc.nextInt();
		int output = 1;
		while(output <= h) {
			System.out.printf("Hello! world%d!!%n", output);
			++output;
		}

		int sum2=0;
		int n2=0;
		System.out.println("숫자를 입력하세요");
		int input = sc.nextInt();
		
		while(n2<=input) {
			sum2=sum2+n2;
			n2=n2+1;
		}
		System.out.printf("1부터 %d까지의 합은 %d 입니다.%n",input,sum2);
		
		sum2=0;
		for(n2=0;n2<=input;n2++) {
			sum2+=n2;
		}
		System.out.printf("1부터 %d까지의 합은 %d 입니다.",input,sum2);
		

	}
	
}
