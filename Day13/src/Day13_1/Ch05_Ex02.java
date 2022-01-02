package Day13_1;

import java.util.HashSet;
import java.util.Random;

public class Ch05_Ex02 {
	// 자주 사용하는 컬렉션
	// set, map, list
	// Set - key도 없고 index도 없다. 순서가 없고 중복된 데이터 저장 X

	public static void main(String[] args) {
		Random rand = new Random();
		HashSet<Integer> lotto = new HashSet<Integer>();
			
		while(lotto.size() < 6) {
			lotto.add(1 + rand.nextInt(6));
		}
		
		System.out.println(lotto);
	}

}
