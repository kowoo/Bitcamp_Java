import java.util.Scanner;

public class a2_Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("원의 개수를 입력하세요 : ");
		int num = sc.nextInt();
		a2[] center = new a2[num];
		a2_2[] circle= new a2_2[num];
		
		int radius, x, y;
		for(int i=0; i<num; i++) {
			System.out.print("원"+(i+1)+"의 반지름을 입력하세요 : ");
			radius = sc.nextInt();
			System.out.print("원"+(i+1)+"의 x축을 입력하세요 : ");
			x = sc.nextInt();
			System.out.print("원"+(i+1)+"의 y축을 입력하세요 : ");
			y = sc.nextInt();
			center[i] = new a2(x, y);
			circle[i] = new a2_2(radius, center[i]);
		}
		
		for(int i=0; i<num; i++) {
			System.out.printf("원%d의 %s %s%n", (i+1), circle[i], center[i]);
		}
		
	}
}
