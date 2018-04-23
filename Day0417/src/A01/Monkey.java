package A01;

public class Monkey {
	public void throwAttack() {
		System.out.println("돌 던지기 공격!!!");
	}
	public void giveUp() {
		System.out.println("바나나를 건네주네요");
	}
	public void fight() {
		System.out.println("원숭이가 공격합니다!");
		throwAttack();
		giveUp();
	}
}
