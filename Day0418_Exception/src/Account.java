
public class Account {
	//잔고 == 정수
	//입출금, 잔고 저장, 잔고 조회
	//입금은 0원 이상 가능

	private int balance;
	public void deposit(int amount) throws NegativeNumberException {
		//더하기 전에 입력받은 수가 음수인지 양수인지 판별해서
		//음수이면 NegativeNumberException 발생시키기
		if(amount<0) {
			throw new NegativeNumberException();
		}
		balance += amount;
	}
	public void withdraw(int amount) throws NegativeNumberException {
		if(balance<amount) {
			throw new NegativeNumberException();
		}
		balance -= amount;
	}
	public void showBalance() {
		System.out.println("잔고는 "+ balance +"원 입니다.");
	}
}
