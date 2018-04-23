package School;
//변수 1개 메소드 1개 추가
public class MiddleStudent extends Student{
	int kumonDay; //0~6, 0:sun,   6:sat
	
	public MiddleStudent() {
		kumonDay = 0;
	}
	
	public int getKumonDay() {
		return kumonDay;
	}

	public void setKumonDay(int kumonDay) {
		this.kumonDay = kumonDay;
	}

	public void studyKumon(int day) {
		if(day == kumonDay) {
			System.out.println("선생님 오는날 인데요?");
		}
	}
}
