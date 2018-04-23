
public class NestedLoop2 {
	public static void main(String[] args) {
		/*
		 * ******
		 * ******
		 * ******
		 * ******
		 * ******
		 * 
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 * 
		 * 
		 *     *
		 *    **
		 *   ***
		 *  ****
		 * *****  
		 * 공백을 문자로 생각하자.
		 * 
		 * @@@@*
		 * @@@**
		 * @@***
		 * @****
		 * ***** 이런식으로!
		 * 그렇다면 @부분도 입력을 해야하니까 for문이 하나 더 필요하겠지
		 * 
		 */

		int a=0;

		for(int i=0;i<5;i++) {
			System.out.println();
			for(int j=1;j<=6;j++) {
				System.out.print("*");
			}
		}System.out.println();

		
		for(int i=0;i<5;i++) {
			System.out.println();
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
		}System.out.println();
		
		
		for(int i=0;i<5;i++) {	//행을 몇번 반복할지 설정
			System.out.println();
			for(int j=1;j<5-i;j++) {	//공백 설정
				System.out.print(" ");
			}
			for(int k=0;k<=i;k++) {	// * 설정
				System.out.print("*");
			}
		}

	}
}
