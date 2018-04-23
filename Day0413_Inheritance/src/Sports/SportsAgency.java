package Sports;

import java.util.Scanner;

public class SportsAgency {
	SportsPlayer[] players;
	boolean isRun;
	int count;
	String search;
	Scanner sc = new Scanner(System.in);

	public SportsAgency() {
		players=new SportsPlayer[100];
		isRun=true;
		count=9;
		players[0] = new SoccerPlayer("축구", "이대호홓", "한국", 48, 4000, 40);
		players[1] = new BaseballBatter("야구", "멍멍이", "미국", 69, 4800, 60);
		players[2] = new TennisPlayer("테니스", "다람쥐", "중국", 73, 4800, 65);
		players[3] = new SoccerPlayer("축구", "고라니", "한국", 48, 5000, 40);
		players[4] = new BaseballBatter("야구", "야옹이", "수단", 69, 6000, 60);
		players[5] = new TennisPlayer("테니스", "강아지", "중국", 73, 5000, 65);
		players[6] = new SoccerPlayer("축구", "캥거루", "호주", 48, 5500, 40);
		players[7] = new BaseballBatter("야구", "없음", "일본", 69, 4800, 60);
		players[8] = new TennisPlayer("테니스", "부폰", "이탈리아", 73, 5000, 65);
	}
	public void start() {		
		int sel=0;
		while(isRun) {
			System.out.println("선수 관리 프로그램");
			System.out.printf("1.선수 정보 조회	2.선수 등록%n3.선수 검색		4.선수 삭제%n5.종료%n");
			System.out.print("원하는 항목 : ");
			sel = sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1:
				System.out.println("======================");
				System.out.println("선수 정보 조회");
				playerInfo();
				break;
			case 2:
				System.out.println("======================");
				System.out.println("선수 등록");
				playerSignUp();
				break;
			case 3:
				System.out.println("======================");
				System.out.println("선수 검색");
				playerSearch();
				break;
			case 4:
				System.out.println("======================");
				System.out.println("선수 삭제");
				playerDelete();
				break;
			case 5:
				System.out.println("======================");
				System.out.println("종료");
				isRun = false;
				break;
			default:
				System.out.println("재입력");
				System.out.println();
			}
		}
	}
	public void playerInfo() {

		System.out.println("1.축구   2.야구   3.테니스   4.전체(요약) : ");
		int choice = sc.nextInt();
		sc.nextLine();
		boolean choiceError = true;
		while(choiceError) {
			if(choice>4 || choice<1) {
				System.out.println("1.축구   2.야구   3.테니스   4.전체(요약) : ");
				System.out.print("선택 : ");
				choice = sc.nextInt();
				sc.nextLine();
			} else {
				break;
			}
		}
		switch(choice) {
		case 1:
			for(int i=0; i<players.length; i++) {
				if(players[i]!=null)
					if(players[i].getType().equals("축구"))
						System.out.println(players[i]);
			}
			break;
		case 2:
			for(int i=0; i<players.length; i++) {
				if(players[i]!=null)
					if(players[i].getType().equals("야구"))
						System.out.println(players[i]);
			}
			break;
		case 3:
			for(int i=0; i<players.length; i++) {
				if(players[i]!=null) {
					if(players[i].getType().equals("테니스")) {
						System.out.println(players[i]);
					}
				}
			}
			break;
		case 4:
			for(int i=0; i<players.length; i++) {
				if(players[i]!=null)
					System.out.println(players[i].normal());
			}
			break;
		}
	}
	public void playerSignUp() {
		System.out.println("1. 축구, 2. 야구, 3. 테니스");
		System.out.print("종목 : ");
		int type = sc.nextInt();
		sc.nextLine();
		System.out.println("======================");

		boolean typeError = true;
		while(typeError) {
			if(type>3 || type<1) {
				System.out.println("1. 축구, 2. 야구, 3. 테니스");
				System.out.print("종목 : ");
				type = sc.nextInt();
				sc.nextLine();
			} else {
				break;
			}
		}

		switch(type) {
		case 1: //축구
			SoccerPlayer tmp = new SoccerPlayer();
			System.out.print("이름 : ");
			tmp.setName(sc.nextLine());
			System.out.print("포지션 : ");
			tmp.setPosition(sc.nextLine());
			System.out.print("오른발? : ");
			tmp.setFoot(sc.nextLine());
			System.out.print("부상 여부 : ");
			tmp.setInjury(sc.nextLine());
			System.out.print("국적 : ");
			tmp.setCountry(sc.nextLine());
			System.out.print("나이 : ");
			tmp.setAge(sc.nextInt());
			sc.nextLine();
			System.out.print("연봉(n만원) : ");
			tmp.setIncome(sc.nextInt());
			sc.nextLine();
			System.out.print("경력(n년) : ");
			tmp.setCareer(sc.nextInt());
			sc.nextLine();
			tmp.setType("축구");
			players[count] = tmp;
			break;
		case 2: //야구
			BaseballBatter tmp2 = new BaseballBatter();
			System.out.print("이름 : ");
			tmp2.setName(sc.nextLine());
			System.out.print("우타? : ");
			tmp2.setHand(sc.nextLine());
			System.out.print("리그 : ");
			tmp2.setLeague(sc.nextLine());
			System.out.print("타율(0.xx) : ");
			tmp2.setbAvg(sc.nextDouble());
			sc.nextLine();
			System.out.print("국적 : ");
			tmp2.setCountry(sc.nextLine());
			System.out.print("나이 : ");
			tmp2.setAge(sc.nextInt());
			sc.nextLine();
			System.out.print("연봉(n만원) : ");
			tmp2.setIncome(sc.nextInt());
			sc.nextLine();
			System.out.print("경력(n년): ");
			tmp2.setCareer(sc.nextInt());
			sc.nextLine();
			tmp2.setType("야구");
			players[count] = tmp2;
			break;
		case 3: //테니스
			TennisPlayer tmp3 = new TennisPlayer();
			System.out.print("이름 : ");
			tmp3.setName(sc.nextLine());
			System.out.print("단식? : ");
			tmp3.setSd(sc.nextLine());
			System.out.print("랭킹 : ");
			tmp3.setRanking(sc.nextInt());
			sc.nextLine();
			System.out.print("선호 코트 : ");
			tmp3.setCourt(sc.nextLine());
			System.out.print("국적 : ");
			tmp3.setCountry(sc.nextLine());
			System.out.print("나이 : ");
			tmp3.setAge(sc.nextInt());
			sc.nextLine();
			System.out.print("연봉(n만원) : ");
			tmp3.setIncome(sc.nextInt());
			sc.nextLine();
			System.out.print("경력(n년) : ");
			tmp3.setCareer(sc.nextInt());
			sc.nextLine();
			tmp3.setType("테니스");
			players[count] = tmp3;
			break;
		}
		count++;
	}	
	public void playerSearch() {
		System.out.print("이름 : ");
		search = sc.nextLine();
		for(int i=0; i<count; i++) {
			if(search.equals(players[i].getName())) {
				System.out.println(players[i]);
			}
		}
	}
	public void playerDelete() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		for(int i=0; i<players.length; i++) {
			if(name.equals(players[i].getName())) {
				System.out.println(players[i]);
				System.out.print("정말 삭제? (Y/N) : ");
				String del = sc.nextLine();
				if(del.equalsIgnoreCase("Y")) {
					System.out.println("삭제완료");
					for(int j=i; j<players.length-1; j++) {
						players[j] = players[j+1];
					}
					count--;
					break;
				}
			}
		}
	}
}