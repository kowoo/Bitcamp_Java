package A02;

public class AnimalTest {
	public static void main(String[] args) {
		Animal[] pet = new Animal[3];
		pet[0] = new Cat();
		pet[1] = new Dog();
		pet[2] = new Monkey();
		
		for(Animal a: pet) {
			a.fight();
			System.out.println("---------------");
		}
	}
	
	
}
