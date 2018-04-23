package Sports;

public class SoccerPlayer extends SportsPlayer {
	String foot;
	String position;
	String injury;
	
	public SoccerPlayer() {
		foot="";
		position="";
		injury="";
	}
	
	public SoccerPlayer(String type, String name, String country, int age, int income, int career) {
		super(type, name, country, age, income, career);
	}

	public String toString() {
		return String.format("종목: %s%2s 이름: %s%2s	포지션: %s%1s 나이: %d%2s"
							+"부상: %s%2s 주력: %s%1s 연봉: %d만원%5s 경력: %d년"
							, getType(), "", getName(), "", position, "", getAge(), "", injury, "", foot, "", getIncome(), "", getCareer());
	}

	public String getFoot() {
		return foot;
	}

	public void setFoot(String foot) {
		this.foot = foot;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getInjury() {
		return injury;
	}

	public void setInjury(String injury) {
		this.injury = injury;
	}


	
}