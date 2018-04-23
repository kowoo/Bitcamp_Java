package A03;

public class AnimalTest {
	public static void main(String[] args) {
		Animal[] pet = new Animal[3];
		Attackable claaaaaaw = new ClawAttack();
		Attackable biteeeeee = new BiteAttack();
		Attackable throoooow = new ThrowAttack();
		GiveUp cGiveUp = new CatGiveUp();
		GiveUp dGiveUp = new DogGiveUp();
		GiveUp mGiveUp = new MonkeyGiveUp();
		
		pet[0] = new Cat(claaaaaaw, cGiveUp);
		pet[1] = new Dog(biteeeeee, dGiveUp);
		pet[2] = new Monkey(throoooow, mGiveUp);
		
		for(Animal a: pet) {
			a.fight();
			System.out.println("---------------");
		}
	}
	
	
}
