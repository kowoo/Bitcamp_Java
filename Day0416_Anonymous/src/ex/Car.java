package ex;

public class Car {
	protected int speed;
	private int mileage;
	private String color;
	private Tire tire;
	
	public void drive() {
		System.out.println("자동차가 굴러가는데");
		tire.roll(5);
	}
	public Car() {
	}
	public Car(Tire tire) {
		this.tire = tire;
	}
}
