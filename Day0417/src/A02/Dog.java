package A02;

public class Dog extends Animal {
	public Dog() {
		this.name = "강아지";
	}
	public void attack() {
		System.out.println("물기 공격!!!");
	}
	public void giveUp() {
		System.out.println("몸을 발라당 뒤집네요");
	}
}
