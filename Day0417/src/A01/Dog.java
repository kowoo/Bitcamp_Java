package A01;

public class Dog {
	public void biteAttack() {
		System.out.println("물기 공격!!!");
	}
	public void giveUp() {
		System.out.println("몸을 발라당 뒤집네요");
	}
	public void fight() {
		System.out.println("개가 공격합니다!");
		biteAttack();
		giveUp();
	}
}
