
public class BreakEx {
	public static void main(String[] args) {
		// break - continue
		// continue : 해당 순서의 반복문을 더 이상 실행하지 않고 다음 반복문으로 넘어간다.
		//			       특정 조건일 때 반복문을 실행하지 않고, 다음 반복으로 실행할 때 사용.

		for(int i=1; i<=10; i++) {
			if(i%5==0) { //i가 5의 배수이므로 브레이크.
				//만약 i가 5의 배수이면 반복문을 종료
				//break;
				//만약 i가 5의 배수이면 생략
				//continue;
			}
			System.out.print(i+" ");
		}

		//중첩반복문에서의 break
		/*
		 * 중첩반복문에서 내가 원하는 반복문을 종료하고 싶을 때 반복문에 태그를 달아주자
		 * 태그1:
		 * 반복문1
		 * 	태그2:
		 * 	반복문2 
		 * 
		 * break 태그1; == 종료하고자 하는 반복문을 선택할 수 있다.
		 * 
		 * 반복문의 이름을 설정하지 않고 바깥쪽 반복문을 종료하기 위해서는
		 * 바깥쪽에 반복문의 종료를 유도할 조건문과 변수를 생성하고
		 * 조건에 맞으면 종료될 수 있게 바꿔주면 된다.
		 * 
		 */

		int count=0;
		boolean isEnd = false;
		outFor: // 반복문 태그 작성
			for(int i=1; i<=7; i++) {
			inFor: // 안쪽 반복문 태그 작성
				for(int j=1; j<=5; j++) {
					//여기는 몇번 들어오나요?
					if(i==3 && j==3) {
						System.out.println(count);
						//isEnd = true;
						break outFor; //태그를 통해 원하는 반복문을 종료할 수 있다.
					} 
					count++;
				}
				if(isEnd) {
					break;
				}
			}
		System.out.println(count);

	}
}
