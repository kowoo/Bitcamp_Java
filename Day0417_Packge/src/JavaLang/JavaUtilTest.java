package JavaLang;

import java.util.Date;
import java.util.Calendar;
public class JavaUtilTest {
	public static void main(String[] args) {
		//java.util : 기본 패키지는 아니다
		//			    하지만 사용하기 편한 클래스들을 많이 제공한다.
		//Date, Calendar, StringTokenizer, Scanner
		
		//Date: 시간을 저장할 수 있는 클래스
		Date date;
		
//		System.out.println(date);
//		System.out.println(date.getMonth()); 작대기로 나와있는건 자바에서 더 이상 지원하지 않는다는 것.
//		date.setMonth(11); //date: month은 0~11
//		System.out.println(date);
		
//		cal.set(Calendar.YEAR, 2017);
//		cal.set(Calendar.MONTH, 11);
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.getTime());
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
		
		//날짜 바꾸기 Calendar set()메서드를 이용
		//set(종류, 시간);
		
		
		date = cal.getTime();
		System.out.println(date);
		
		Date d1 = new Date(cal.getTimeInMillis());
		System.out.println(d1);
		
	}
}
