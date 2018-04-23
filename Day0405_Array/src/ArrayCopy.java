
public class ArrayCopy {
	public static void main(String[] args) {
		//배열 복사(값 복사, 주소 복사)
		int num1 = 10;
		int num2 = num1; // 이게 깊은 복사(Deep copy)
		
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
		//num2를 증가시킴
		num2++;
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
		
		
		int[] arr1 = {1, 3, 5};
		int[] arr2 = arr1;
		
		arr2[0]++; // arr2[0]을 변경했는데 arr1[0]도 변경됐다. 이렇게 주소값을 불러와서 값을 수정하는 것을 얕은 복사(Shallow copy)라고 부른다
		System.out.print("arr1 : ");
		for(int num: arr1) {
			System.out.print(num+" ");
		}
		System.out.print("\narr2 : ");
		for(int num: arr2) {
			System.out.print(num+" ");
		}
		
		//깊은 복사(Deep copy) : 모든 원소를 하나 하나 복사
		arr2 = new int[arr1.length];
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = arr1[i];
		}
		//깊은 복사 후 증가
		arr2[0]++;
		System.out.print("\narr1 : ");
		for(int num: arr1) {
			System.out.print(num+" ");
		}
		System.out.print("\narr2 : ");
		for(int num: arr2) {
			System.out.print(num+" ");
		}
	
	}
}

