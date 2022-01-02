package Day06;

import java.util.Arrays;
import java.util.Scanner;

public class Ch03_Ex23 {
	static Scanner scan = new Scanner(System.in);
	
	public static void main01(String[] args) {
		int[] score = {95, 70, 85, 90, 100, 45, 35, 85, 70, 75};
		
		System.out.print("검색 할 점수 >> ");
		int num = scan.nextInt();
		
		// 65를 입력 받아서 65가 있으면 true를 아니면 false 출력
		// 검색 할 점수 >> 65
		// 결과 65는 배열에 없습니다!
		
		// 1. 점수를 입력 받는다
		// 2. 입력받은 점수가 배열에 있는가? 검색
		// 3. 있다면 count한다
		
		int cnt = 0;
		for(int i = 0; i < score.length; i++) {
			if(score[i] == num) {
				cnt++;
			} 
		}
		// 4. 검색 종료 후 결과 출력
		if(cnt == 0) {
			System.out.printf("결과 : %d는 배열에 없습니다!", num);
		} else {
			System.out.printf("결과 : %d는 배열에 %d개 있습니다!", num, cnt);
		}
	}
	
	public static void main02(String[] args) {
		// 배열에 점수를 입력 받아서 제일 큰 점수와 제일 작은 점수를 출력
		
		int[] score = new int[5];
		int max = 0, min = 100;
		
		for(int i = 0; i < score.length; i++) {
			System.out.print("점수 입력" + (i ) + " >> ");
			int num = scan.nextInt();
			if(num > max) {
				max = num;
			} 
			if(num < min) {
				min = num;
			}
		}
		System.out.printf("가장 큰 점수 : %d, \n가장 작은 점수 : %d", max, min);
	}
	
	public static void main03(String[] args) {
		int[] score = {65, 100, 75, 80, 35, 90};
		int[] rank = new int[score.length];
		
		// score을 순서를 정렬한후 오름차순으로 순서 붙이기
		// 결과 : [5, 1, 4, 3, 6, 2]
		
		// 0. score 요소의 갯수만큼 반복하면서...
		// 1. rank[i]번째를 1로 시작한다.
		// 2. score[i]번째보다 큰 값의 요소가 있다면 rank[i]를 증가한다
		// 		(같은 배열의 요소끼리 비교하기)
		
		int size = score.length; 
		// 변수를 선언하는 이유 : 힙에 계속 물어봐야하기 때문에 스택에서 변수로 선언해 바로바로 사용할수있어서
		// 		속도의 부하가 걸리지 않음
		for(int i = 0; i < size; i++) {
			rank[i] = 1;
			for(int j = 0; j < size; j++) {
				if(score[i] < score[j]) {
					rank[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(rank));
		System.out.println();
		
		for(int i = 0; i < score.length; i++) {
			System.out.printf("%d점은 %d등 입니다.\n", score[i], rank[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] score = {95, 70, 85, 90, 100, 45, 35, 85, 70, 75};
		
		// 점수 검색 : 70
		// 결과 : 70은 1번째 8번째에 있습니다.
		
		// 1. 검색어 입력 받기
		// 2. score의 요소만큼 반복
		// 3. 검색어와 같은 값이 있다면 위치 출력
		
		System.out.print("점수 검색 : ");
		int num = scan.nextInt();
		
		int cnt = 0;
		int a = 0;
		int b = 0;
		boolean flag = false;
		
		System.out.printf("결과 : %d은 ", num);
		for(int i = 0; i < score.length; i++) {
			if(num == score[i]) {
				System.out.print(i + "번째 ");
				flag = true;
			}
			if(score[i] == num) {
				cnt++;
			}
		}
		if(flag) {
			System.out.printf("에 %d개 있습니다!", cnt);
		} else {
			System.out.print("없습니다");
		}
	}
}
