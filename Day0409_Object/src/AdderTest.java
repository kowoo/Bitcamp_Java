import java.util.Scanner;

public class AdderTest {
	public static void main(String[] args) {
		//더하기 기능을 하는 클래스를 작성해서
		//더하기 기능 실행출해보기(add)
		//상태값: 결과를 저장하는 result(정수)
		//기능add() : 숫자 2개를 전달 받아서 더 한 다음 결과를
		//			상태값 result에 저장하고 출력하는 기능
		
		//Adder 클래스의 기능 add를 사용하기 위해서는 객체를 생성해야한다
		//더하기 기능을 사용하기 위해 객체 생성후 참조 변수 adder에 참조 시킴.
		Adder adder = new Adder();
		//a가 가지고 있는 add() 메서드 호출
		//add()메서드는 매개변수로 2개의 정수를 가짐
		//호출 시 정수 2개를 인자로 줘야한다
		
		int num1 = 3;
		int num2 = 5;
		adder.add(num1, num2);
		
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		adder.add(n1, n2);

	}

}
