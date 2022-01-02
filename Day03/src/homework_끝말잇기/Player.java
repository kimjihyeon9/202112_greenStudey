package homework_끝말잇기;

// 생성자 - 해결
// getWordFromUser - 해결
// checkSuccess - 해결
public class Player {
//	private String name = ""; 
	// private을 쓰려면 아래에 getter, setter 을 사용하여 WordGameApp에서 getName을 불러와서 사용한다
	String name = "";
	String word = "";
	
	Player(String name){ // 함수 -> 생성자 만들었다
		this.name = name;
	}
	
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public String getName() {
//		return word;
//	}
	
	// 플레이어가 갖은 단어을 반환하는 함수 정의
	public String getWordFromUser() {
		return word;
	}
	
	public boolean checkSuccess(String prevword) {
		int lastIndex = prevword.length() - 1;			// 마지막 문자에 대한 인덱스, 여기의 word는 이전단어에 대한 길이 필요
		char lastChar = prevword.charAt(lastIndex);		// 마지막 문자
		char firstChar = word.charAt(0);				// 첫 번째 문자
		
		if(lastChar == firstChar) {
			// 두음법칙을 허용한다면 여기에 조건을 붙여서 return을 하면 된다
			return true;
		} else {
			return false;
		}
	}
}
