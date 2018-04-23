
public class NestedLoop {
	public static void main(String[] args) {
//		System.out.println("**********");
//		System.out.println("**********");
//		System.out.println("**********");
//		System.out.println("**********");
//		System.out.println("**********");
//		System.out.println("**********");
		
		for(int i=1; i<=6; i++) {
			//System.out.print("*");
			for(int j=1; j<=10; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
		for(int x=2; x<=9; x++) {
			System.out.println(x+"단");
			for(int y=1; y<=9; y++) {
				System.out.printf("%d * %d = %d%n", x, y, x*y);
			}
		}
		
		for(int i=1; i<=6; i++) {
			//System.out.print("*");
			for(int j=1; j<=10; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
		for(int x=1; x<=9; x++) {
			System.out.println();
			for(int y=2; y<=4; y++) {
				System.out.printf("%d * %d = %d		", y, x, y*x);
			}
		}






	}
}
