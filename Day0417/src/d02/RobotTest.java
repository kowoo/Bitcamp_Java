package d02;

//import A02.TaekwonV;

public class RobotTest {
	public static void main(String[] args) {
		Robot[] robots = new Robot[3];
		robots[0] = new Transformer();
		//robots[1] = new TaekwonV();
		robots[2] = new Gundam();
		
		for(Robot robot: robots) {
			robot.fight();
			System.out.println("-----------------");
		}
	}
	

}
