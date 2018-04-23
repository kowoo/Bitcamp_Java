public class TimeTest {
	public static void main(String[] args) {
		Time time = new Time(11, 40, 15);
		//Time.setTime(11, 40, 15);
		//time.showTime();
		
		String strTime = time.timeString();
		//System.out.println(strTime);
		//toString() 메서드를 활용하면 객체의 멤버 변수의 값을 쉽게 출력할 수 있다.
		System.out.println(time);
		//위에서 쓰인 time은 time.toString()을 호출하는 것.
		
		
//		int[] arr = new int[5];
//		System.out.println(arr);
		
	}
	
}
