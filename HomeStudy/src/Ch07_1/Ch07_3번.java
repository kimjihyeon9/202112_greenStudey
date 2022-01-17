package Ch07_1;

import java.util.HashMap;
import java.util.Scanner;

public class Ch07_3번 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer> nations = new HashMap<>();
		
		System.out.println("나라 이름과 인구를 입력하세요.(예 : Korea 5000");
		while(true) {
			System.out.print("나라 이름, 인구 >> ");
			String 나라 = scan.next();
			if("그만".equals(나라)) break;
			
			int 인구 = scan.nextInt();
			nations.put(나라, 인구);
		}
		
		while(true) {
			System.out.print("인구 검색 >> ");
			String 나라 = scan.next();
			if("그만".equals(나라)) break;
			
			if(nations.containsKey(나라)) {
				System.out.println(나라 + "의 인구는 " + nations.get(나라));
			} else {
				System.out.println(나라 + "나라는 없습니다.");
			}
		}
	}

}
