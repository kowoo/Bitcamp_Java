
public class ArrayEx3 {

	public static void main(String[] args) {
		//배열 사용 실습
		int x;
		double y;
		
		int[] a = new int[3]; //값을 저장하지 않았기 때문에 기본값인 0 출력, 실수는 0.0
		double[] b = new double[10];
		
		//배열의 객체를 생성하면 각 원소들은(숫자데이터라면) 0으로 초기화 된다
		//참조형 변수의 배열을 생성하면 null로 초기화 된다
		
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		
		int[] arr = {1, 3, 5};
		//1, 3, 5로 초기화된 크기 3의 정수형 배열 생성
		//단, 변수 선언시에만 사용할 수 있다
		
		//int[] arr;
		//arr = {1, 3, 5}; 에러 발생
		
		System.out.println(arr.length);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		int[] arr2 = {}; //크기 0인 배열을 만들어서 참조변수에 참조시킨다
		// 거의 쓰이지 않지만 사용하면 nullpointer 예외가 발생하지않는다
		// 즉, 배열이 0개인 것과 null인 것은 다름
		
		//for-each 반복문 : 배열의 데이터의 모든 원소를 한 번씩 검사하고자 할 때 사용한다
		/*
		 * for(원소의 데이터 타입: 배열){
		 * 
		 * }
		 */
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		//배열의 모든 원소에 대해서 반복 실행을 원할때 사용
		for(int num:arr) { //for-each
			System.out.println(num);
		}

	}
	
}
