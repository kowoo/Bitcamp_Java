import java.util.Scanner;

public class FindValue2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1, num2, num3, mid, middle;
		System.out.println("경고! 서로 다른 숫자를 입력하지 않으면 오류가 발생합니다!");
		System.out.print("첫 번째 숫자를 입력하세요 : ");
		num1 = scan.nextInt();
		System.out.print("두 번째 숫자를 입력하세요 : ");
		num2 = scan.nextInt();
		System.out.print("세 번째 숫자를 입력하세요 : ");
		num3 = scan.nextInt();

		mid = num1<num2? (num2<num3? num2: (num1<num3? num3: num1)): (num3<num2? num2: (num3<num1? num3: num1));
		System.out.printf("두 번째로 높은 수는 %d입니다.%n", mid);

		middle = num1>num2 && num1>num3? (num2>num3? num2 : num3)
				:(num2>num1 && num2>num3? (num1>num3? num1 : num3)
						:(num1>num2? num1: num2));
		System.out.printf("두 번째로 높은 수는 %d입니다.%n", middle);
		
		
		//강사님이 작성한 코드
		/* 1. 2개씩 비교해서 각각 큰 수를 저장.
		 * 2. 큰 수 2개와 중간 수 하나를 저장.
		 * 3. 셋 중에서 작은 것이 중간 수.
		 * 
		 * a>b, b>c, c>a 비교의 결과값을 x, y, z에 저장한다. 
		 * 이후 x > y > z를 비교해서 가장 작은 변수가 정답이 된다.
		 */
		int x, y, z; // 입력받은 값을 저장
		int a, b, c; // 입력받은 값끼리 비교
		int result; // 최종 결과
		System.out.print("첫 번째 숫자를 입력하세요 : ");
		x = scan.nextInt();
		System.out.print("두 번째 숫자를 입력하세요 : ");
		y = scan.nextInt();
		System.out.print("세 번째 숫자를 입력하세요 : ");
		z = scan.nextInt();
		
		a = x>y? x: y;
		b = y>z? y: z;
		c = x>z? x: z;
		result = a<b? a: (b<c? b: c);
		System.out.println("중간 수는 " + result + "입니다.");
		
		
		
		
		
	}

}
