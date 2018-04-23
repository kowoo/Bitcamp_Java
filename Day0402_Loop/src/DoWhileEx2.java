import java.util.Scanner;

public class DoWhileEx2 {
	public static void main(String[] args) {
		//사용자가 특정한 수를 맞추는 프로그램 작성
		//사용자에게 숫자를 입력받고 입력받은 수가 큰지 작은지 알려준다
		//정답을 입력하면 정답! 이라고 알려주고 종료
		//do=while 문을 사용

		int answer = 67;
		int number;
		Scanner scan = new Scanner(System.in);

		//해야할 일
		//답을 정해야 한다, 숫자를 입력받아야한다. 그러므로 정수타입 변수 2개 생성
		//숫자가 큰지 작은지, 정답인지 알려줘야하므로 조건문이 필요하다.
		//오답일 경우 반복해야하므로 반복문을 사용해야 한다.
		//정답일 경우 정답! 이라 알려줘야 하므로 출력문도 필요함.



		do { //잘 사용되지는 않지만 알아두자. do-while은 최초 한번 실행은 무조건 되게 만들기 위해 사용된다.
			System.out.println("정수를 입력해주세요.");
			number = scan.nextInt();
			if(number>answer) {
				System.out.println("정답보다 큰 숫자를 입력하셨습니다.");			
			} else if(number<answer){
				System.out.println("정답보다 작은 숫자를 입력하셨습니다.");			
			}else {
				System.out.println("정답!");
			}
		}while(answer!=number);
	}
}
