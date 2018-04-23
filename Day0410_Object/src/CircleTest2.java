public class CircleTest2 {
	public static void main(String[] args) {
		Point p = new Point(3,4);
		p.setX(5);
		p.setY(10);
		
		Circle c1 = new Circle(5, p);
		c1.printE();
		p.setX(3);
		p.setY(3);
		c1.printE();
		//System.out.println(c1.area());
		//System.out.println(c1.circum());
		
		String area = c1.area();
		String circum = c1.circum();
		
		Circle c2 = new Circle(5, 3, 4); //(radius, x, y)
		c2.printE();
		
//		System.out.println("둘레: "+ circum + " 넓이 : "+area);
		System.out.println(c1.area());
	}
}
