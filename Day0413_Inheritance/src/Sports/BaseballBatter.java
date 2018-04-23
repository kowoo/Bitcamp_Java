package Sports;

public class BaseballBatter extends SportsPlayer {
	String hand;
	String league; // KBO, MLB, NPB
	double bAvg;

	public BaseballBatter() {
		super.setType("야구");
		league="KBO";
		hand="없음";	
		bAvg=0;
	}

	public BaseballBatter(String type, String name, String country, int age, int income, int career) {
		super(type, name, country, age, income, career);
	}

	public String toString() {
		return String.format("종목: %s%2s 이름: %s%2s	주력: %s%1s 나이: %d%2s"
				+"리그: %d%2s 타율: %s%1s 연봉: %d만원%5s 경력: %d년"
				, getType(), "", getName(), "", hand, "", getAge(), "", league, "", bAvg, "", getIncome(), "", getCareer());
	}

	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public double getbAvg() {
		return bAvg;
	}

	public void setbAvg(double bAvg) {
		this.bAvg = bAvg;
	}


}