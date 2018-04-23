
public class Score {
//	OddNumberException
//	(홀수일때 발생시키는 예외)
//
//	Score 클래스 작성
//	총점(total)을 저장하고,
//	설정(setTotal(int): void)하고, 
//	출력(showTotal() : void)할 수 있는 클래스
//	setTotal()할 때 홀수가 입력되면 OddNumberException 발생
//
//	ScoreTest 만들고
//	main에서 값 넣어보기
	int total;
	public void setTotal(int a) throws OddNumberException {
		if(a%2==1) {
			throw new OddNumberException();
		}
		total+=a;
	}
	public void showTotal() {
		System.out.println("합계는 "+total+"입니다.");
	}

}
