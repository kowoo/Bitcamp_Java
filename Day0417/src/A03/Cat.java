package A03;
public class Cat extends Animal {
	public Cat(Attackable attack, GiveUp giveUp) {
		this.name = "고양이";
		this.attack = attack; // 의존성 주입, 제어 역전이라고 한다.
		this.giveUp = giveUp;
	}
}
