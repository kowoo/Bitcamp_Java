package Sports;

public class SportsPlayer {
	private String type;
	private String name;
	private String country;
	private int age;
	private int income;
	private int career;
	
	public SportsPlayer() {
		type="종목없음";
		name="이름없음";
		country="국적없음";
		age=0;
		income=0;
		career=0;
	}
	
	public SportsPlayer(String type, String name, String country, int age, int income, int career) {
		this.type = type;
		this.name = name;
		this.country = country;
		this.age = age;
		this.income = income;
		this.career = career;
	}
	
	public void play() {
		System.out.println("운동을 합니다.");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}
	
	public String toString() {
		return "";
//				String.format("종목 : %s 이름 : %s, 국적 : %s, 나이 : %d%n연봉 : %d만원, 경력 : %d년",
//							type, name, country, age, income, career);
	}
	
	public String normal() {
		return String.format("이름: %s%2s	나이: %d%2s연봉: %d", name, "", age, "", income);
	}
	
}
