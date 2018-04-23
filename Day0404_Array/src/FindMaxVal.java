import java.util.Scanner;

public class FindMaxVal {

	public static void main(String[] args) {
		//1. 임의의 숫자 5개로 초기화된 배열 생성
		//2. 이후 가장 큰 숫자를 찾아서 출력
		//예)
		//가장 큰 숫자는 100입니다.

//반복문 미사용		
//		int[] nums = {77, 50, 64, 100, 25};
//		
//		int big1 = nums[0]<nums[1]? nums[1]: nums[0];
//		int big2 = nums[2]<nums[3]? nums[3]: nums[2];
//		int big3 = big2<nums[4]? nums[4]: big2;
//		int big4 = big1<big3? big3: big1;
//		
//		System.out.println("가장 큰 숫자는 "+big4+"입니다.");
//		
		
		Scanner sc = new Scanner(System.in);
		int[] nums2 = new int[5];
		int big=nums2[0];
		for(int i=0; i<nums2.length; i++) {
			nums2[i] = sc.nextInt();
		}
		
		for(int i=0; i<nums2.length; i++) {
			big = big<nums2[i]? nums2[i]: big; // == if (nums2[i]>big) { big=nums2[i]; }	
		}
		System.out.printf("가장 큰 숫자는 %d입니다.", big);
		
		/* for each
		for(int nums2 : arr) {
			if(nums2>big) {
			big=nums2;
			}
		} 맞나?.. 검토
		
		*/
	}
	
}
