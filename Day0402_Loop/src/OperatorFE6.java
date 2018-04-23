import java.util.Scanner;

public class OperatorFE6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		boolean result1 = a>b;
		boolean result2 = a<b;
		boolean result3 = a>=b;
		boolean result4 = a<=b;
		
		System.out.println(a+" > "+b+" --- "+result1);
		System.out.println(a+" < "+b+" --- "+result2);
		System.out.println(a+" >= "+b+" --- "+result3);
		System.out.println(a+" <= "+b+" --- "+result4);
		
	}

}
