import java.util.Scanner;

public class CircleTest3 {
	public static void main(String[] args) {
		//사용자로부터 다수의 원의 반지름과 중심점의 좌표를 입력받아서
		//출력하는 프로그램 작성
		/*
		 * 입출력 예) 
		 * 	저장할 원의 개수를 입력하세요 // 3이라면 3번 반복
		 * 		3
		 * 	원의 반지름을 입력하세요
		 * 		10
		 * 	원의 x좌표를 입력하세요
		 * 		3
		 * 	원의 y좌표를 입력하세요
		 * 		5
		 * 
		 * 	입력받고 난 이후
		 * 원 1의 반지름은 3, 넓이는 xxx.xx 중심좌표는 3, 5
		 * 원 2의 반지름은 3, 넓이는 xxx.xx 중심좌표는 3, 5 
		 * 원 3의 반지름은 3, 넓이는 xxx.xx 중심좌표는 3, 5  반복문으로 ㄱㄱ
		 */
		
		/* 
		 * 여러개의 원을 반복문을 통해서 한까번에 처리
		 * Circle c1;
		 * c1: 원 하나의 정보를 처리할 수 있는 참조변수
		 * 하지만, 하나가 아닌 여러개의 원을 처리해야 하는 변수가 필요하다.
		 * 그러므로 배열 선언
		 * int num = sc.nextInt();
		 * Circle[] cArr = new Cricle[입력받은 수];
		 * 배열을 만들고 나면 해당하는 배열의 원소는 Circle 객체의 주소값을 저장할 수 있다.
		 * 배열[3]이면 3개의 주소값을 저장. 
		 */
		
		Scanner sc = new Scanner(System.in);

		int radius, x, y;
		System.out.println("저장할 원의 개수를 입력하세요.");
		int number = sc.nextInt();
		Circle[] c = new Circle[number];
		Point[] center = new Point[number];
		
		for(int i=0; i<number; i++) {
			System.out.println("원의 반지름을 입력하세요");
			radius = sc.nextInt();
			System.out.println("원의 x좌표를 입력하세요");
			x = sc.nextInt();
			System.out.println("원의 y좌표를 입력하세요");
			y = sc.nextInt();
			center[i] = new Point(x,y);
			c[i] = new Circle(radius, center[i]);
		}
		
		for(int i=0; i<number; i++) {
			System.out.printf("원%d의 %s 중심 좌표는 %s%n", (i+1), c[i], center[i]);
		}
		
	}
}
