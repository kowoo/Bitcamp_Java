
public class Operator4 {
	public static void main(String[] args) {
		//비트 연산자
		// &, |, ^, ~
		// ^(XOR) : 둘 중 하나만 1이어야 1.
		// ~ : 1 = 0, 0 = 1

		int x = 3;
		int y = 6;
		int result;

		/*
		x & y
		x 		0011
		y 		0110
		x & y 	0010
		 */
		result = x&y;
		System.out.println("x & y : " + result);

		/*
		x | y
		x 		0011
		y 		0110
		x | y 	0111
		 */
		result = x|y;
		System.out.println("x | y : " + result);

		/*
		x ^ y
		x 		0011
		y 		0110
		x ^ y	0101
		 */
		result = x^y;
		System.out.println("x ^ y : " + result);

		/*
		~ x
		x 		0011 == 3
		~ x 	1100 == -4 // 맨 앞의 비트가 음, 양을 결정하므로 이런 결과가 나온다.
		 */
		x = ~x;
		System.out.println("~ x : " + x);

		/*3개의 비트로 표현할 수 있는 수의 개수 : 7
		  2의 보수 방식으로 음수를 표시한다.
		0	000			000	0
		1	001			001	1
		2	010			010	2
		3	011			011	3

		4	100	
		5	101	110+1	111	-1
		6	110	101+1	110	-2
		7	111	100+1	101	-3
						100	-4
		 */

		System.out.println(Integer.toBinaryString(-1)+'\n');


		// 시프트 연산자 : 비트를 옮기는 연산자 <<, >>, >>>
		/*
		0111 << 1 == 1110 : << 좌측으로 옮김. 빈자리는 0
		1110 >> 1 == 0111 : >> 우측으로 옮김. 빈자리는 0, 부호비트는 유지
		1100 >>>1 == 1010 : >>> 우측으로 옮김. 빈자리는 0
		 */
		
		x = 7; // 0111
		result = x << 1; // 1110
		System.out.println("7  << 1 : " + result); // 좌측으로 1칸 이동 == *2
		
		result = x >> 1; // 0011
		System.out.println("7  >> 1 : " + result); // 우측으로 1칸 이동 == /2
		
		
		//탐구
		x = -7; // 0111
		result = x >> 1; // 0100
		System.out.println("-7 >> 1 : " + result); // 
		

	}
}
