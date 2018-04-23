import java.util.Random;
public class Dice {
	public static void main(String[] args) {
		// 주사위 만들기 (1~6)
		// 랜덤숫자 생성 방법 : Math클래스 이용, Random클래스 이용
		
		Random ran = new Random();
		int dice = ran.nextInt(6)+1; // (n) 0~n-1까지의 숫자를 생성. 6이니 0~5.
		
		//switch 문으로 dice가 어떤 숫자인지 출력하는 문장 작성
		
		switch(dice) {
		case 1:
			System.out.println("주사위에서 1이 나왔습니다.");
			break;
		case 2:
			System.out.println("주사위에서 2이 나왔습니다.");
			break;
		case 3:
			System.out.println("주사위에서 3이 나왔습니다.");
			break;
		case 4:
			System.out.println("주사위에서 4가 나왔습니다.");
			break;
		case 5:
			System.out.println("주사위에서 5가 나왔습니다.");
			break;
		default:
			System.out.println("주사위에서 6이 나왔습니다.");
			break;
		}
		
		
		//Math 이용하기 : 수학과 관련된 기능들과 값들을 저장하고 있는 클래스
		//random()  : 0<=실수<1 를 생성한다.
		//random(6) : 0<=실수<6 를 생성한다.
		//실수를 정수로 형변환 하고 1을 더하면 주사위 완성
		
		int ranNum = (int)(Math.random()*6)+1;
		System.out.println("주사위에서 " + ranNum + "이(가) 나왔습니다.");
		
	}
}
