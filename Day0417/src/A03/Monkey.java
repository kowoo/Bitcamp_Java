package A03;

public class Monkey extends Animal {
	public Monkey(Attackable attack, GiveUp giveUp) {
		this.name = "원숭이";
		this.attack = attack; // 의존성 주입, 제어 역전이라고 한다.
		this.giveUp = giveUp;
	}
}
