package ex1;



public class Bus extends Car {
	boolean isOpen; //트루
	
	public Bus() {
		isOpen = false;
	}
	
	public void switchGate() {
		if(isOpen) {
			System.out.println("문을 닫습니다.");
		} else {
			System.out.println("문을 엽니다.");
		}
		isOpen = !isOpen;
	}
	
	
}
