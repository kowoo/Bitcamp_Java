package ex3;

import java.util.Scanner;

public class Start {
	public int select;
	Scanner sc = new Scanner(System.in);
	public Start() {
		System.out.println("선의 개수를 입력해주세요.");
		this.select = sc.nextInt(); 
	}
		
	public void Shape() {
		if(this.select==1) {
			new Circle();
		}
		if(this.select==3) {
			new Triangle();
		}
		if(this.select==4) {
			new Rectangle();
		}
	}


}
