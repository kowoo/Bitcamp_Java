import java.util.Scanner;
public class Object_Review1 {
	Scanner sc = new Scanner(System.in);
	//사용자로 부터 숫자 4개를 입력받아서
	//작은 순으로 출력하는 프로그램을 작성하자
	//입출력 예)
	// 숫자1을(를) 입력하세요 : 1
	// 숫자2을(를) 입력하세요 : 2
	// 숫자3을(를) 입력하세요 : 3
	// 숫자4을(를) 입력하세요 : 4
	// 입력한 숫자의 내림차 순은 4, 3, 2, 1 입니다.
	
	int[] nums;
	
	public Object_Review1() {
		nums =new int[];
	}
	
	public Object_Review1(int num) {
			nums =new int[num];
	}
	
	public void in_Num() {
		for(int i=0; i<nums.length; i++) {
			System.out.print("숫자"+(i+1)+"을(를) 입력하세요 : ");
			nums[i] = sc.nextInt(); 
		}
	}

	public void check() {
		int tmp=0;
		for(int i=0; i<nums.length; i++) {
			for(int j=i; j<nums.length; j++) {
				if(nums[j]>nums[i]) {
					tmp=nums[i];
					nums[i]=nums[j];
					nums[j]=tmp;
				}
			}
		}
	}
	
	public String toString() {
		return nums[input];
	}
}
