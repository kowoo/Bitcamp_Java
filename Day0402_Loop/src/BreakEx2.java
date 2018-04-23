import java.util.Scanner;

public class BreakEx2 {

	public static void main(String[] args) {
		//사용자에게 정수를 입력받으면 정수의 배수를 출력한다. (단, 100미만의 숫자만 입력가능)
		//100이 넘어 갈 경우 출력하고 종료
		//예)
		// 숫자를 입력하세요
		// 21
		// 21 42 63 84 105
		
		Scanner sc= new Scanner(System.in); // Scanner는 사용자로부터 무언가를 입력받기 위해 사용된다.
		System.out.println("숫자를 입력하세요"); // 입력을 유도하기 위한 출력문
		int num = sc.nextInt(); // 입력받은 숫자를 저장할 변수
		int num2 = 0; // 숫자의 배수를 저장할 변수
		
		while(true) {
			num2+=num; // 배수를 저장한다. 
			if(num2<100) { // num2가 100미만인 경우
				System.out.print(num2+" ");
			} else { // 100이상인 경우
			System.out.println(num2);
			break; // 100이상이므로 break를 통해 while문을 빠져나온다.
			}
		}

	}

}
