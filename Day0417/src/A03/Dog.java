package A03;

public class Dog extends Animal {
	public Dog(Attackable attack, GiveUp giveUp) {
		this.name = "강아지";
		this.attack = attack; // 의존성 주입, 제어 역전이라고 한다.
		this.giveUp = giveUp;
	}
}
