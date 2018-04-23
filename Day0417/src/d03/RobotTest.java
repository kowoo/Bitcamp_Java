package d03;

public class RobotTest {
	public static void main(String[] args) {
		Robot[] robots = new Robot[3];
		Attackable gunAttack = new GunAttack();
		Moveable flyMove = new FlyMove();
		Attackable punchAttack = new PunchAttack();
		Moveable runMove = new RunMove();
		
		robots[0] = new Transformer(gunAttack,runMove);
		robots[1] = new TaekwonV(punchAttack,flyMove);
		robots[2] = new Gundam(gunAttack,flyMove);
		
		for(Robot robot: robots) {
			robot.fight();
			System.out.println("-----------------");
		}
	

		
	}
}
