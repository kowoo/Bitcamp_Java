public class Operator2 {
	public static void main(String[] args) {
		int x = 3;
		int y = 4;
		boolean result;

		result = x == y;
		System.out.println("x == y : " + result);
		result = x != y;
		System.out.println("x != y : " + result);
		result = x > y;
		System.out.println("x > y : " + result);
		result = x < y;
		System.out.println("x < y : " + result);
		result = x >= y;
		System.out.println("x >= y : " + result);
		result = x <= y;
		System.out.println("x <= y : " + result + '\n');
		
		// 결과는 boolean이다.
		
		System.out.println("!result :" + !result); // ! : true, false 값을 반대로 만들어 준다. 
		System.out.println("result :" + result + '\n');
		
		// &&, ||
		boolean result1 = x==1;
		boolean result2 = y==4;
		boolean result3;
		boolean result4;
		
		result3 = result1 && result2;
		result4 = result1 || result2;
		System.out.println("result1 && result2 : " + result3);
		System.out.println("result1 || result2 : " + result4);
	}
}
