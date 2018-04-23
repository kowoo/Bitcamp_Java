package thread3;

public class BankAccount {
	private int balance;
	
	//balance에 값을 더함
	public synchronized void deposit(int amount) {
		balance = balance + amount;
	}
	
	public synchronized void withdraw(int amount) {
		balance = balance - amount;
	}
	
	public synchronized int getBalance() {
		return balance;
	}
	
	//synchronized: 하나의 메서드가 사용 중 일 때 다른 메서드는 접근할 수 없다!
}
