import java.util.Scanner;

public class Multiply2 {
	public static void main(String[] args) {
		int a, b, result;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("a의 값을 입력하세요 : ");
		a = scan.nextInt();
		System.out.print("b의 값을 입력하세요 : ");
		b = scan.nextInt();
		
		result = a*b;
		System.out.print("a곱하기 b의 값은 " + result + "입니다.");
	}

}
