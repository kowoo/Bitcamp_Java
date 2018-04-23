package Sports;

public class TennisPlayer extends SportsPlayer {
	String court;
	int ranking;
	String sd;
	
	public TennisPlayer() {
		court="없음";
		ranking=0;
		sd="단식";
	}
	
	public TennisPlayer(String type, String name, String country, int age, int income, int career) {
		super(type, name, country, age, income, career);
	}

	public String toString() {
		return String.format("종목: %s%2s 이름: %s%2s	단식/복식: %s%1s 나이: %d%2s"
							+"랭킹: %d%2s 선호코트: %s%1s 연봉: %d만원%5s 경력: %d년"
							, getType(), "", getName(), "", sd, "", getAge(), "", ranking, "", court, "", getIncome(), "", getCareer());
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getSd() {
		return sd;
	}

	public void setSd(String sd) {
		this.sd = sd;
	}

}
