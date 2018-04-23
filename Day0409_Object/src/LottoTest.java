
public class LottoTest {
	public static void main(String[] args) {
/*		
		1. 1~45사이의 중복되지 않는 6개의 수를 생성하는 lotto 클래스 만들기
		2. 상태값은 생성된 로또 번호를 저장할 수 있는 크기 6인 정수형 배열(lotto)
		3. 기능
			3-1. 랜덤한 숫자를 만들어 내고 lotto에 저장하는 makeNumber() void
			3-2. 만들어진 배열을 정렬하는 sort() void
			3-3. 만들어진 배열을 출력하는 printlotto() void
		4. 배열을 받아서 lotto에 넣어줄 수 있는 생성자 1, 기본 생성자 1
		5. lottoTest main에서 lotto 객체 만들어서 메서드 하나씩 실행
*/
		Lotto lotto = new Lotto();
		lotto.makeNumber();
		lotto.sort();
		lotto.printLotto();
		
		int[] arr = {2, 4, 7, 44, 13, 3};
		Lotto lotto2 = new Lotto(arr);
		lotto2.printLotto();
		lotto2.sort();
		lotto.printLotto();
		
		//arr 내용 직접 출력 : 참조에 의한 호출이기 때문에 정렬이 된다.
		for(int num: arr) {
			System.out.print(num+" ");
		}
		
	}
}
