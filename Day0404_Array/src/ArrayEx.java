
public class ArrayEx {

	public static void main(String[] args) {

		int s1, s2, s3;
		s1 = 100;
		s2 = 90;
		s3 = 80;

		//정수형 데이터 3개를 저장할 수 있는 배열 생성하기
		//1. (정수형) 배열의 주소를 저장할 수 있는 참조 변수 만들기
		// 만들 배열의 종류는 정수형 배열

		int[] numbers = null; // 정수값을 저장할 수 있는 참조 변수 생성, 생성만 하고 아무것도 안하고 싶으면 null
		numbers = new int[3]; // 배열 만들기 & 주소값 참조변수에 넣음
		// == int[] numbers = new int[3];
		
		// numbers = 5; numbers는 배열의 주소값을 저장하는 변수이므로 정수를 그대로 넣을 수 없다.
		// 배열은 index를 통해서 사용 할 수 있다.
		// index == 배열 요소의 순서를 나타내는 번호, 0부터 시작 num[3]이라고 하면 0, 1, 2
		
		// 첫 번째 칸에는 1, 두 번째 칸에는 3, 세 번째 칸에는 5를 넣어보자.
		numbers[0] = 1;
		numbers[1] = 3;
		numbers[2] = 5;
		
		System.out.println(numbers[0]);
		System.out.println(numbers[1]);
		System.out.println(numbers[2]);
		
		for(int i=0; i<numbers.length; i++) { //배열 이름.length == 해당 배열의 길이
			System.out.println(numbers[i]);
		}
		


	}
}
