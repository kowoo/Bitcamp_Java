
public class Score {
	public static void main(String[] args) {
		//학생들의 점수가 저장되는 2차원 배열을 생성
		//2차원 배열은 각 반 별로 저장이 된다. 
		// 1반은 {100,90,88,90} 네 명
		// 2반은 {90,77,60} 세 명
		// 3반은 {100,100,50,50,40} 다섯 명
		// 4반은 {100,99,80,90,100,0} 여섯 명
		// 각 반의 총점과 평균을 구하라
		// 단, 평균은 소수점 첫째자리 까지만 표시, 각 반별 학생 수도 달라야 한다.
		/*출력 예) 1반:  총점  366점,  평균 91.5점
		        2반:  총점  xxx점,  평균 xx.x점
		        3반:  총점  xxx점,  평균 xx.x점
		        4반:  총점  xxx점,  평균 xx.x점
		 */

//		int[][] score = new int[4][];
//
//		int[] a = {100, 100, 100, 99};
//		int[] b = {70, 73, 80};
//		int[] c = {40, 47, 55, 67, 68, 51};
//		int[] d = {30, 18, 37, 15, 40};
//
//		score[0] = a;
//		score[1] = b;
//		score[2] = c;
//		score[3] = d;
		int[][] score = {{100, 100, 100, 99}, {70, 73, 80}, {40, 47, 55, 67, 68, 51}, {30, 18, 37, 15, 40}};

		for(int i=0; i<score.length; i++) {
			int sum1=0;
			double avg1=0;
			for(int j=0; j<score[i].length; j++) {
				sum1 = sum1+score[i][j];
				avg1 = (double)sum1/score[i].length;	
			}
			System.out.printf("%d반: 총점 %d점, 평균 %.1f점, %d명%n", i+1, sum1, avg1, score[i].length);
		}

	}
}
