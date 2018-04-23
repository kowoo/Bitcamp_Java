
public class DoubleArray {
	public static void main(String[] args) {
		//이차원 배열 : 배열을 저장할 수 있는 배열
		//정수형 데이터를 저장할 수 있는 배열을 연습해보자
		int[] intArr = new int[3];
		int[][] doubleArr = new int[3][3];

		//크기 5인 정수형 배열을 저장하는 크기 3인 배열
		//arr 정수형 배열의 주소값을 저장하는 배열의 주소값을 저장하는 참조변수
		int[][] arr = new int[3][5];

		System.out.println(arr.length); //2차원 배열의 길이 == 3
		System.out.println(arr[0].length); //정수형 배열의 길이 == 5 

		//arr[0], arr[1], arr[2]
		//는 정수형 배열의 주소값을 저장하는 참조변수

		//arr[0][0]...등
		//정수형 변수
		for(int i=0; i<arr.length; i++) {
			//얘가 3번 반복
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
				//arr[j][i]로 해버릴 경우 j가 2를 초과하는 순간 에러가 발생한다.
				//왜? [3][5]의 크기이므로 [0,1,2][0,1,2,3,4]이기 때문
			}
			System.out.println();
		}
		
		//정수 5개를 저장할 수 있는 배열 a 선언 및 생성
		int[] a = new int[5];
		//정수형 배열 3개를 저장할 수 있는 배열b 선언 및 생성
		int[][] b = new int[3][];
		//크기 4인 정수형 배열 6개를 저장하는 배열c 선언 및 생성
		int[][] c = new int[6][4];
		
		double[] d = new double[3];
		b[0] = a;
		// b[1] = d; b는 정수형 배열의 주소값만 저장가능 
		System.out.println("[b][0][0] : "+b[0][0]);
		
		a[0] = 10;
		b[0][1] = 20;
		System.out.println("[b][0][0] : "+b[0][0]);
		System.out.println("[b][0][1] : "+b[0][1]);
		System.out.println("[a][1] : "+a[1]);
		//a[0]만 변경하고 b[0]을 변경하지 않았는데 10으로 출력된다
		//왜냐하면 b[0][0]은 a[0]의 주소값만 저장하기 때문이다
		//반대로 b[0][1]을 20으로 바꿔도 a[1]도 20이 된다.
		//a[1]도 주소값이기 때문
		
		
		
		//크기 3인 정수형 배열
		int[] a2 = {5, 10, 20};
		b[1] = a2;
		//크기 6인 정수형 배열
		int[] a3 = {10, 15, 20, 43, 23, 67};
		b[2] = a3;
		
		//2차원 배열을 반복문에서 사용할 때,
		//각 원소 배열의 길이를 사용하면, 배열간 길이가 다르더라도 모든 원소에 접근할 수 있다.
		for(int i=0; i<b.length; i++) {
			for(int j=0; j<b[i].length; j++) {
				System.out.printf("%2d ", b[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		//배열에서 값을 초기화 하면서 배열 생성하기
		int[] arr1 = {10, 20, 30, 1, 2};
		//2차원 배열에서 값을 초기화 하면서 배열 생성하기
		int[][] arr2
		= {{2,3,4}, {1,2,3}, {1,1,1,1,1,1}, {10,20}};
		
		for(int num: arr1) {
			System.out.print(num+" ");
		}
		System.out.println();
		
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.printf("%2d ", arr2[i][j]);
			}
			System.out.println();
		}
		
	}
}
