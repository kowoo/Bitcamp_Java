package prototype2;

import java.io.Serializable;

public class Store implements Serializable{
	private String name;
	private String type;
	private String teleNumber;
	private String openClosed;
	private String price;
	private String score;
	
	public Store() {}
	public Store(String name, String type, String teleNumber, String openClosed, String price, String score) {
		super();
		this.name = name;
		this.type = type;
		this.teleNumber = teleNumber;
		this.openClosed = openClosed;
		this.price = price;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTeleNumber() {
		return teleNumber;
	}
	public void setTeleNumber(String teleNumber) {
		this.teleNumber = teleNumber;
	}
	public String getOpenClosed() {
		return openClosed;
	}
	public void setOpenClosed(String openClosed) {
		this.openClosed = openClosed;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Eatery [name=" + name + ", type=" + type + ", teleNumber=" + teleNumber + ", openClosed=" + openClosed
				+ ", price=" + price + ", score=" + score + "]";
	}
	
}
