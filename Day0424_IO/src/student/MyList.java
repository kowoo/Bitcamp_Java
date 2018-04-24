package student;

import java.util.List;

/*	ArrayList의 동작과 매우 비슷한 List만들기									
 * add(E): 파라미터로 전달받은 데이터를 array에 추가								v						
 * remove(int): 인덱스를 전달받아서 array에 해당 인덱스의 데이터를 삭제				v		
 * get(int): 인덱스를 전달받아서 해당 인덱스의 데이터를 반환							v
 * size(): array 길이 반환												v
 * set(int, E): 특정 인덱스에 데이터 넣기
 */

@SuppressWarnings("unused")
public class MyList<E> {
	//데이터를 저장하기 위해서는 배열이 필요하다.
	private E[] array;

	@SuppressWarnings("unchecked")
	public MyList() {
		//크기 0인 배열 생성
		//array = new E[0]; // 얘는 객체를 만들어내는 코드이기 때문에 타입이 정확하게 명시되어야 한다.
		//그래서 안됨.
		array = (E[]) new Object[0];
	}
	
	public int size() {
		return array.length;
	}
	
	@SuppressWarnings("unchecked")
	public void add(E data) {
		E[] tmp = (E[]) new Object[array.length+1];
		for(int i=0; i<array.length; i++) {
			tmp[i] = array[i];
		}
		tmp[array.length] = data;
		array = tmp;
	}
	
	@SuppressWarnings("unchecked")
	public void remove(int index) {
		E[] tmp = (E[]) new Object[array.length-1];
		int n=0;
		for(int i=0; i<array.length; i++) {
			if(i!=index) {
				tmp[n] = array[i];
				n++;
			}
		}
		array = tmp;
	}
	
	public E get(int index) {
		return this.array[index];
	}
	
	public void set(int index, E e) {
		array[index] = e;
	}
	
	@SuppressWarnings("unchecked")
	public void set2(int index, E e) {
		E[] tmp = (E[]) new Object[array.length+1];
		for(int i=0; i<array.length; i++) {
				tmp[i] = array[i];
			if(i>=index) {
				tmp[i+1] = array[i];
			}
		}
		tmp[index] = e;
		array = tmp;
	}
	
}

//for(int i=0; i<array.length; i++) {
//	tmp[i] = array[i];
//	if(i==index) {
//		for(int j=index; j<array.length; j++) {
//			tmp[j+1] = array[j];
//		}
//	}
//	tmp[index] = e;
//	break;
//	array = tmp;