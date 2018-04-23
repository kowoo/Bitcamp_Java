
public class Switch {

	public static void main(String[] args) {
		//if-else문과 마찬가지로 선택 제어문 중 하나
		//하지만 서로 다르다. if-else는 조건문이 오지만 switch는 변수의 값에 따른 선택이 일어난다.

		int number = 2;
		
		switch(number) {
		case 0: 
			System.out.println("number는 0입니다.");
			break;
		case 1:
			System.out.println("number는 1입니다.");
			break;
		case 2:
			System.out.println("number는 2입니다.");
			break;
		default:
			System.out.println("number는 0, 1, 2가 아닙니다.");
			break;
		}
		
		
	}

}
