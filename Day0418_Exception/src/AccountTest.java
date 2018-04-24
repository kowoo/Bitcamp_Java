
public class AccountTest {
	public static void main(String[] args) throws NegativeNumberException {
		Account myAccount = new Account();
		try {	
			myAccount.deposit(100000000);
			System.out.println("입금완료");
		}catch(NegativeNumberException e){
			e.getStackTrace();
			System.out.println("입금 금액이 잘못되었습니다.");
		}
		myAccount.showBalance();
		
		try {	
			myAccount.withdraw(200000000);
			System.out.println("출금불가");
		}catch(NegativeNumberException e){
			throw new NegativeNumberException(); // 얘를 넣으려면 메인 옆에다가 쓰로우를 추가해야함!
			//e.getStackTrace();
			//System.out.println("출금 금액이 잘못되었습니다.");
		}
		myAccount.showBalance();
		
		
		
		
	}
}
