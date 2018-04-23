package ex2;

public class Cat extends Animal{
	
	public Cat() {
		name="야옹이";
		numOfLegs=4;
	}
	
	public Cat(String name, int numOfLegs) {
		this.name = name;
		this.numOfLegs = numOfLegs;
	}

	public void meow() {
		System.out.println("야옹");
	}
	
	public void sound() {
		System.out.println("야옹");
	}
	
	
	@Override
	public String toString() {
		return "Cat [name=" + name + ", numOfLegs=" + numOfLegs + "]";
	}
}
