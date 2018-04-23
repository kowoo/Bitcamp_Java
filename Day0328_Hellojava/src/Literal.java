
public class Literal {
	public static void main(String[] args) {
		// 이번 예제에서는 Literal (값, 상수)에 대해서 공부합니다.
		/*
		정수를 표현할 때 보통 10진수를 사용하지만 8진수나 16진수, 2진수를 사용하기도 한다.
		10진수	2진수		8진수		16진수
		1		01		1		1
		2		10		2		2
		3		11		3		3
		4		100		4		4
		10		1010	12		a
		15		1111	17		f
		20		10100	24		14
		 */
		
		int decimal; //10진수를 저장할 변수
		int octal; //8진수를 저장할 변수
		int hexadecimal; //16진수를 저장할 변수
		int binary; //2진수를 저장할 변수
		
		decimal = 14;
		octal = 016;
		hexadecimal = 0x0e;
		binary = 0b1110;
		
		System.out.printf("decimal : %d%n",decimal);
		System.out.printf("octal : %d%n",octal);
		System.out.printf("hexadecimal : %d%n",hexadecimal);
		System.out.printf("binary : %d%n",binary);
		
		//Integer 정수와 관련된 기능을 만들어 놓은 클래스
		//정수를 16, 8, 2진수 문자열 형태로 바꿀 수 있음
		
		String hexaStr = Integer.toHexString(14);
		String octaStr = Integer.toOctalString(14);
		String binaryStr = Integer.toBinaryString(14);
		
		System.out.println(hexaStr);
		System.out.println(octaStr);
		System.out.println(binaryStr);
		
		
	}

}
