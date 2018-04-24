package thread5;

public class Test {
	public static void main(String[] args) {
		Buffer buf = new Buffer();
		Runnable pro = new Pro(buf);
		Runnable cus = new Cus(buf);
		
		Thread p = new Thread(pro);
		Thread c = new Thread(cus);
		
		p.start();
		c.start();
		
		
	}

}
