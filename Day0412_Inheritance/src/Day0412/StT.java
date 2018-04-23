package Day0412;

public class StT {
	public static void main(String[] args) {
		St student = new St();
		System.out.println(student.getGrade());
		student.setGrade(5);
		System.out.println(student.grade);
		
		St st = new St("바보", 3, new Sc(100,99));
		System.out.println(st);
	}

}
