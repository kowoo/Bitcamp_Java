
public class Time {
	//시, 분, 초를 저장할 수 있는 변수
	//변수들은 외부에서 직접 수정하지 못하도록 private로 설정
	
	//생성자: 기본 생성자/시, 분, 초를 매개변수로 받는 생성자
	//메서드: setTime() 시, 분, 초를 매개변수로 받아서 멤버 변수에 설정
	//		showTime(): 시간은 x시 x분 x초 입니다. 라고 출력하는 메서드
	//		시는 0~23, 분과 초는 0~59까지만 입력가능
	//		범위를 벗어날 경우 0으로 추가한다.
	
	//TimeTese만들고 main에서 Time객체를 만들어서 시간 설정후 출력
	private int hour;
	private int minute;
	private int second;
	
	public Time() {
		//그냥 아무것도 작성하지 않으면 각 0으로 초기화, 기본 생성자
	}
	public Time(int hour, int minute, int second) {
		//시, 분, 초를 매개변수로 받는 생성자
//		hour = hour;
//		minute = minute;
//		second = second;
		//setTime이라는 메서드에서 조건 검사를 작성했기 때문에
		//setTime을 호출해서 조건 검사를 실행
		//만약 위처럼 hour =hour;~~~로 작성하면 코드가 중복되므로 낭비
		setTime(hour, minute, second);
		
	}
	public void setTime(int hour, int minute, int second) {
		//변수에다가 값을 넣기 전 조건 검사가 필요함.
		if(hour>23||hour<0) {
			hour=0;
		}
		if(minute>60||minute<0) {
			minute=0;
		}
		if(second>60||second<0) {
			second=0;
		}
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public void showTime() {
		System.out.printf("시간은 %02d시 %02d분 %02d초 입니다.%n", hour, minute, second);
	}
	
	public void setHour(int hour) {
		//멤버 변수에 hour
		//매개 변수(로컬 변수==지역 변수)에 hour, 같은 이름을 가지고 있다.
		//메서드 안에서 'hour'이라는 이름을 사용하면
		//지역 변수가 사용 된다.
		//그런데 멤버 변수에다가 값을 넣어야한다.
		//이때 this 키워드가 사용 : 클래스 내부에서 객체를 지칭 (멤버 변수를 부를 때 사용)
		this.hour = hour; // this.hour == 멤버 변수의 hour를 지칭한다.
		//로컬 변수를 받아와서 멤버 변수를 수정하기 위해 필요.
	}
	
	public int getHour() {
		return this.hour;
	}
	//getter,setter 자동생성
	//source > generate getter/setter
	
	//showTime에서 출력했던 문자열을 반환하는 메서드
	public String timeString() {	
		//시간은 %02d시 %02d분 %02d초 입니다.%n
		String str = hour+"시 "+minute+"분 "+second+"초 입니다.";
		return str;
	}
	
	//toString()은 원래 있는 메서드 == 우리가 원하는 모양으로 바꿔주는 역할
	//객체의 멤버변수(상태값) 내용을 쉽게 확인하기 위해서 사용
	public String toString() {
		String str = hour+"시 "+minute+"분 "+second+"초 입니다.";
		return str;
	}
	
}
