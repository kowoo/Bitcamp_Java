package list;

public class Abc {
	public static void main(String[] args) {
		byte a = 127;
		int b = a;
		b = a+1;
		a = (byte) b;
		System.out.println(a);		
		
		
//		System.out.printf("%d의 16진수 값은 %x입니다.",a,a);
		
	}
}
