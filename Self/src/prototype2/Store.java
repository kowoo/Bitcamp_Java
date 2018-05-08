package prototype2;

import java.io.Serializable;

public class Store implements Serializable{
	private int num;
	private String name;
	private int price;
	private int score;
	
	public Store() {}
	public Store(int num, String name, int price, int score) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.score = score;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
