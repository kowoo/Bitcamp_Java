package A02;

public class Monkey extends Animal {
	public Monkey() {
		this.name = "원숭이";
	}
	public void attack() {
		System.out.println("돌 던지기 공격!!!");
	}
	public void giveUp() {
		System.out.println("바나나를 건네주네요");
	}
}
