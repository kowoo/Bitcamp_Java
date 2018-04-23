
public class LoopEx {

	public static void main(String[] args) {
		/*
		* 반복문은 특정한 문장(들)을 여러번 반복해서 실행하고자 할 때 사용한다.
		* 종류 : while, for, do while
		*
		*1. while : 조건식을 만족한다면, 문장을 반복해서 실행한다.
		*2. for : 보통, 문장을 반복하고자 하는 횟수가 정해져 있을 때 사용한다.
		*3. do while : while + 문장을 최소 한 번은 실행하고자 할 때 사용한다.
		*
		*	while(조건식) {
		*		//조건식이 참이면 실행할 문장;
		*	}
		*	if(조건식) {
		*		//조건식이 참이면 실행할 문장;
		*	}
		*/
		
		int x = 1;
		while(x <= 10) {
			System.out.printf("Hello! world%d!!%n", x); // 이대로 놔두면 무한히 반복해서 진행한다. 무한루프라고 부름.
			++x; // 이렇게 조건식을 벗어날 수 있는 방법을 마련해줘야 한다.
		}

				
	}

}
