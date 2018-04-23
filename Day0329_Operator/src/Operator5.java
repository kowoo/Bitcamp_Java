import java.util.Scanner;

public class Operator5 {
	public static void main(String[] args) {
		// 조건 삼항 연산자
		// 조건식?값1:값2	조건식 true = 값1, false = 값2

		// grade : 학년, 4학년 이상 이면 용돈 500, 3학년 이하면 100
		int grade = 3;
		int pocketMoney;

		pocketMoney = grade <= 3? 100: 500;
		System.out.println(pocketMoney);

		/*
		a%=b == a=a%b
		1) (a%=b) == 0   : (a=a%b) == 0
		2) a%=b == 0     : a=a%b == 0
		 */

	}
}
