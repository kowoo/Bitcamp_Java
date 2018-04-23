public class Student {
	int numOfSubject; //과목수
	int totalScore; //총점
	
	public Student() {
		
	}
	public Student(int totalScore,int numOfSubject) {
		this.totalScore = totalScore;
		this.numOfSubject = numOfSubject;
	}
	//public void showAverage() throws ArithmeticException{ //예외를 발생하게 만든 메서드에서 처리하게 만듬
	public void showAverage() throws Exception{ //여러개를 던져주고 싶으면 , ㄱㄱ
		
		int result = totalScore/numOfSubject;
		
//		try {
//			throw new Exception();
//		}catch(Exception e) {
//			System.out.println("예외 발생");
//		}
		
//		try {
//			int result = totalScore/numOfSubject;
//			System.out.println(result);
//		}catch(ArithmeticException e) {
//			System.out.println("0으로 나누면 안됩니다!");
//		}
	}
}
