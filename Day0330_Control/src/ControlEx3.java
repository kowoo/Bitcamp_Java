import java.util.Scanner;

public class ControlEx3 {
	public static void main(String[] args) {
		//if-else 를 이용한 학점 계산하기
		//점수를 입력받아서
		//점수가 90이상일 경우 'A'
		//	   80이상일 경우 'B'
		//	   70이상일 경우 'C'
		//	   60이상일 경우 'D'
		//	   60미만일 경우 'E'

		int score;
		char grade=' ';
		Scanner scan = new Scanner(System.in);

		System.out.print("점수를 입력하세요 : ");
		score = scan.nextInt();

		if(score>=90) {
			grade = 'A';
		}else {
			if(score>=80)
				grade = 'B';
			else
				if(score>=70)
					grade = 'C';
				else 
					if(score>=60)
						grade = 'D';
					else 
						if(score<60)
							grade = 'E';		
		}
		System.out.printf("등급은 %c입니다.%n", grade);


		if(score>=60) {
			if(score>=70) {
				if(score>=80) {
					if(score>=90) {
						grade = 'A';
					}else grade = 'B';
				}else grade = 'C';
			}else grade = 'D';
		}else grade = 'E';
		System.out.printf("등급은 %c입니다.%n", grade);

		
		if(score>=90 && score<=100) {
			grade = 'A';
		}
		if(score>=80 && score<90) {
			grade = 'B';
		}
		if(score>=70 && score<80) {
			grade = 'C';
		} 
		if(score>=60 && score<70) {
			grade = 'D';
		}
		if(score<60) {
			grade = 'E';		
		}
		System.out.printf("등급은 %c입니다.%n", grade);
		
		
		if(score>=90) {
			grade = 'A';
		}
		else if(score>=80) {
			grade = 'B';
		}
		else if(score>=70) {
			grade = 'C';
		}
		else if(score>=60) {
			grade = 'D';
		}
		else {
			grade = 'E';	
		}
		System.out.printf("등급은 %c입니다.%n", grade);


	}
}
