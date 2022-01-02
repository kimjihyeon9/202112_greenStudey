package Day13;

import java.util.Scanner;

public class Ch03_Ex02 {

	public static Scanner scan = new Scanner(System.in);
	
	public static void main01(String[] args) {
		// 여러개의 정수를 입력한다. 끝내려면 -1을 입력한다
		// -1이 입력 되지 전까지 숫자를 계속 입력 받는 프로그램
		// 입력 받은 숫자 중 -1을 제외한 숫자들의 평균을 출력한다.
		// avg = 총점 / count
		int total = 0;
		int count = 0;
		double avg = 0.0;
		
		System.out.println("-1이 입력 될때까지 연속적으로 숫자 입력 받기.");
		System.out.print("입력 >> ");
		int number = scan.nextInt();
		
		while(number != -1) {
			count++;
			total += number;
			number = scan.nextInt();
		}
		System.out.println("입력 끝!");
		
		avg = (double) total / (double) count;
		System.out.printf("정수의 개수는 %d개이며 평균은 %.1f입니다.\n", count, avg);
	}
	
	// TDD - 테스트 주도개발
	public static void main(String[] args) {
		// 단어를 입력 받는 프로그램 구현
		// "끝"이 입력 될때까지 단어를 계속 입력 받는다.
		// 입력 된 단어들 중에서 가장 긴 단어를 출력한 프로그램을 while문을 이용해서 구현하라
		
		// "끝"이 입력 될때까지 단어 입력 받기
		String newWord = "";
		
		System.out.println("단어를 연속해서 입력 하라, (종료는 끝 입력)");
		System.out.print("입력 >> ");
		String word = scan.next();
		
		while(!word.equals("끝")) {
			if(word.length() > newWord.length()) {
				newWord = word;
			}
			word = scan.next();
		}
		System.out.println("입력 완료!");
		System.out.println(newWord);
		
/*		System.out.println("\"끝\"이 입력 될때까지 연속적으로 단어 입력받기.");
		System.out.print("입력 >> ");
		String word = scan.next();
		String l = "";
		
		while(!word.equals("끝")) {
			if(word.length() > l.length()) {
				l = word;
			}
			word = scan.next();
		}
		System.out.println("입력 끝!");
		System.out.printf("가장 긴 단어는 \"%s\" 이고 길이는 %d이다", l, l.length());
*/
	}

}
