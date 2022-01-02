package Ch05_실습문제풀이_5;

// 실습문제 10번

abstract class PairMap{
	protected String[] keyArray; // key 들을 저장하는 배열
	protected String[] valueArray; // value 들을 저장하는 배열
	abstract String get(String key); // key 값을 가진 value 리턴. 없으면 null 리턴
	abstract void put(String key, String value); // key 와 value를 쌍으로 저장. 기존에 key 가 있으면 값을 value로 수정
	abstract String delete(String key); // key 값을 가진 아이템(value와 함께) 삭제. 삭제된 value값 리턴
	abstract int length(); // 현재 저장된 아이템의 개수 리턴
}

class Dictionary extends PairMap{
	private int top;
	private int capacity;

	public Dictionary(int capacity) {
		keyArray = new String[capacity];
		valueArray = new String[capacity];
		top = 0;
		this.capacity = capacity;
	}

	@Override
	String get(String key) {
		// keyArray에서 key와 같은 key가 있는지 검색한다
		// 같은 key가 있다면 key와 같은 index의 value를 반환한다
		for(int i = 0; i < top; i++) {
			if(key.equals(keyArray[i])) {
				return valueArray[i];
			}
		}
		return null;
	}

	@Override
	void put(String key, String value) {
		// 1. keyArray 에서 key와 같은 key가 있는지 검사하기
		// 		1-1. keyArray의 0번지 부터 top전까지 순회하기
		// 2. 같은 key가 있다면 key와 같은 index의 valueArray에 value 저장
		// 3. 없다면 top번지의 keyArray에 key 저장, top번지의 valueArray에 value저장
		// 4. 만약 top이 keyArray의 크기 이상이라면 (가변적인 구조) capacity 크기 만큼 증가한
		// 		4-1. 새 keyArray와 새 valueArray를 만들고 기존 값 복제 후 마지막 요소로 추가
		
		boolean flag = false;
		
		for(int i = 0; i < top; i++) {
			if(key.equals(keyArray[i])) { // 비교할때 : 문자열.equals(변수)
				valueArray[i] = value;
				flag = true;
				break;
			}
		}
		if(!flag) {
			try {
				keyArray[top] = key;
				valueArray[top] = value;
			} catch (ArrayIndexOutOfBoundsException e) {
				String[] newKeyArr = new String[keyArray.length + capacity];
				String[] newValueArr = new String[valueArray.length + capacity];
				for(int i = 0; i < keyArray.length; i++) {
					newKeyArr[i] = keyArray[i];
					newValueArr[i] = valueArray[i];
				}
				keyArray = newKeyArr;
				valueArray = newValueArr;
				keyArray[top] = key;
				valueArray[top] = value;
			} finally {
				top++;
			}
		}
	}

	@Override
	String delete(String key) { 
		// key의 위치를 찾아서 제거한다
		String value = null;
		for(int i = 0; i < keyArray.length; i++) {
			if(key.equals(keyArray[i])) {
				value = valueArray[i];
				for(int j = i; j < top - 1; j++) {
					keyArray[j] = keyArray[j+1];
					valueArray[j] = valueArray[j+1];
				}
				keyArray[top-1] = null;
				valueArray[top-1] = null;
				top--;
			}
		}
		// keyArray.length - capacity > top 
		// 배열을 줄여서 다시 만들고 복제하기
		if((keyArray.length - capacity) > top ) {
			String[] newKeyArr = new String[keyArray.length - capacity];
			String[] newValueArr = new String[keyArray.length - capacity];
			for(int i = 0; i < top; i++) {
				newKeyArr[i] = keyArray[i];
				newValueArr[i] = valueArray[i];
			}
			keyArray = newKeyArr;
			valueArray = newValueArr;
		}
		return value;
	}

	@Override
	int length() {
		return top;
	}
	
	int capacity() {
		return keyArray.length;
	}
	
	@Override
	public String toString() {
		String mapValueStr = "{";
		for(int i = 0; i < top; i++) {
			mapValueStr = mapValueStr + keyArray[i] + ":" + valueArray[i] + ",";
		}
		mapValueStr = mapValueStr.substring(0, mapValueStr.length() -1) +  "}";
		return mapValueStr;
	}

}

public class DictionaryApp {

	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("홍길동", "자바");
		dic.put("김길동", "파이썬");
		dic.put("최길동", "자바스크립트");
		dic.put("이길동", "자바스크립트");
		
		System.out.println(dic);
		System.out.println("capacity >> " + dic.capacity());
		System.out.println("김길동의 값은 " + dic.get("김길동"));
		System.out.println("홍길동의 값은 " + dic.get("홍길동"));
		
		dic.delete("홍길동");
		
		System.out.println("홍길동의 값은 " + dic.get("홍길동")); // null
		System.out.println(dic);
		System.out.println("capacity >> " + dic.capacity());
		
		dic.delete("최길동");
		dic.delete("이길동");
		System.out.println(dic);
	}

}
