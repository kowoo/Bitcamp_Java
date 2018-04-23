package interface2;

public class DrawableTest {
	public static void main(String[] args) {
		Drawable[] d=new Drawable[3];
		d[0] = new Circle();
		d[1] = new Triangle();
		d[2] = new Rectangle();
		
		for(Drawable d2: d) {
			d2.draw();
		}
		
	}
}
