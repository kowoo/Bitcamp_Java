package week_02;

import java.util.Scanner;

public class SwitchString {
	public static void main(String[] args) {
		//스위치문에 스트링이 올 수 있다.
		Scanner menu = new Scanner(System.in);
		String str;
		System.out.print("피자? 치킨? : ");
		str = menu.nextLine();



		switch (str) {
		case "피자":
			System.out.println("피자는 없습니다.");
			break;
		case "치킨":
			System.out.println("치킨은 없습니다.");
			break;
		default :
			System.out.println("둘 중 하나만 입력해주세요.");
			break;
		}


	}

}
