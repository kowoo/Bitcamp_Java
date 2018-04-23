
public class a2_2 {

	a2 center;
	int radius;

	public a2_2() {
		radius=0;
	}
	public a2_2(int radius, a2 center) {
		this.radius= radius;
		this.center= center;
	}

	public String areaRoundA2() {
		return String.format("넓이 : %.2f, 둘레 : %.2f, 중심 : ", 3.14*radius*radius, 3.14*radius*2);
	}
	
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String toString() {
		return String.format("%s", areaRoundA2());
	}

}
