import java.util.Scanner;

public class Add2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a, b, sum;
		
		System.out.print("a의 값을 입력하세요 : ");
		a = scan.nextInt(); // 키보드에서 입력받은 int 값을 a에 할당
		System.out.print("b의 값을 입력하세요 : ");
		b = scan.nextInt(); // 키보드에서 입력받은 int 값을 a에 할당
		
		sum = a+b;
		System.out.println("a더하기 b의 결과는 " + sum + "입니다.");

		
	}

}
