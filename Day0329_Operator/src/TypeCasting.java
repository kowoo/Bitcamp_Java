
public class TypeCasting {
	static int e;
	public static void main(String[] args) {
		//암시적 변환 == 자동변환
		//데이터의 손실이 없으며, 작은 타입에서 큰 타입으로 변환된다.(== 확대변환)
		
		double b = 2; //2가 2.0으로 자동변환이 된다.
		b = 3.5 * 4;  //4가 4.0으로 자동변환이 된다. 실수 * 정수 = 실수
		
		//명시적 변환 == 강제변환
		//데이터의 손실이 있을 수 있으며, 큰 타입에서 작은 타입으로 변환한다. (== 축소변환)
		int a = (int)123.5; // 123까지만 저장된다.
		b = a; // 다시 더블 값으로 돌려도 123.0으로 0.5는 손실된다.
		

		
		
		
	}

}
