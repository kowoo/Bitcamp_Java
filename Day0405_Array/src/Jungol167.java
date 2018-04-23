import java.util.Scanner;

public class Jungol167 {

	public static void main(String[] args) {
		//4x2 이차원 배열 생성 후, 순서대로 사용자에게 입력받기
		//(크기 2인 정수형 배열 4개를 저장 할 수 있는 배열)
		int[][] arr = new int[4][2];
		Scanner input = new Scanner(System.in);
		
		for(int i =0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length;j++) {
				arr[i][j] = input.nextInt();
			}
		}
		
		int[] sumCol = new int[2];
		int sumTotal=0;
		int count=0;
		for(int i =0; i<arr.length; i++) {
			int sumRow = 0; //가로 평균		
			for(int j=0; j<arr[i].length;j++) {
				//안쪽 for문이 끝날 때 마다 총합과 평균을 구하면 된다.
				sumRow += arr[i][j];
				sumTotal += arr[i][j];
				sumCol[j] += arr[i][j];
				count++;
			}
			//sumRow는 총합.
			System.out.print(sumRow/arr[i].length+" "); // 가로평균
		}
		System.out.println();
		
		for(int i=0; i<sumCol.length; i++) {
			System.out.print(sumCol[i]/4+" ");
		}
		System.out.println();
		System.out.println(sumTotal/count);
		
	}
			
}
