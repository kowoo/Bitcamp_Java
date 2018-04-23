
public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {3, 5, 4, 1, 2, 6, 7, 10};
		//중첩반복을 이용해야 한다
		
		//1. 첫번째 칸부터 가장 작은 값을 찾아서 넣는다.
		//0번에 들어갈 가장 작은 수를 찾는다. 0번부터 4번까지 반복
		//1번에 들어갈 가장 작은 수를 찾는다. 1번부터 4번까지 반복
		//2번에 들어갈 가장 작은 수를 찾는다. 2번부터 4번까지 반복
		//3번에 들어갈 가장 작은 수를 찾는다. 3번부터 4번까지 반복
		//4번에 들어갈 가장 작은 수를 찾는다. 4번부터 4번까지 반복
		
		//1. 현재 인덱스의 값을 최소값으로 지정
		//2. 배열의 0번부터 4번까지 비교
		
//		for(int i=0; i<arr.length; i++) {
//			int tmp = arr[i];
//			for(int j=i+1; j<arr.length; j++) {
//				if(tmp>arr[j]) {	
//					tmp = arr[j];
//					arr[j] = arr[i];
//					arr[i] = tmp;
//				}
//			}
//		}
//		for(int num: arr) {
//			System.out.print(num+" ");
//		}
		
		
	
		//최소값을 찾아서 바로 바꾸지 않고, 자리 위치만 가지고 있기
		for(int i=0; i<arr.length; i++) {
			//알고 있어야하는 값 == 최소값, 최소값의 자리 번호
			int minVal; //최소값
			int minPos; //최소값 자리 번호
			
			minVal = arr[i];
			minPos = i;
			for(int j=i; j<arr.length; j++) {
				if(minVal > arr[j]) {
					minVal = arr[j];
					minPos = j;	//최소값 위치 저장
				}
			}
			arr[minPos] = arr[i];
			arr[i]=minVal;
			//최소값을 찾아서 최소값과 현재 자리에 있는 값을 바꿔주기		
		}
		for(int num: arr) {
		System.out.print(num+" ");
	}
		
		
		
	}
}
