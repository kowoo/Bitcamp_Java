import java.util.Scanner;

//저축액을 계산하는 프로그램 작성
//저축액(정수)을 입력 받아서 10년 동안 저축액(원금)을 구하는 프로그램 작성
//단, 10년동안 같은 금액을 저축한다고 가정

public class Salary {
	public static void main(String[] args) {
		int a, b, total;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("저축액을 입력하세요 : ");
		a = scan.nextInt();
		
		total = a*12*10;
		System.out.println("10년 동안의 저축액 : " + total + "원");
		
		/*
		System.out.print("저축액을 입력하세요 : ");
		a = scan.nextInt();
		
		System.out.print("기간을 입력하세요(연) : ");
		b = scan.nextInt();
		
		total = a*12*b;
		System.out.println(b + "년 동안의 저축액 : " + total + "원");*/
		
	}

}
