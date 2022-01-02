package Day05;

import java.util.Arrays;
import java.util.Scanner;

public class Ch03_Ex07_달력과제 {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] days;
		days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		System.out.printf("1년은 %d개월 입니다.\n", days.length);
		
		System.out.print("월 입력>>> ");
		int month = scan.nextInt();
		// 과제1 : 날짜 입력 유효성 체크 구현
		while(true) {
			if(month > 12 || month < 1) {
				try {
					System.out.println("입력하신 월은 없는 일입니다.");
					System.out.print("월 입력>>> ");
					month = scan.nextInt();
					break;
				} catch (Exception e) {
					scan.next();
				}
			} else {
				break;
			}
		}
		
		System.out.print("일 입력>>> ");
		int day = scan.nextInt();
		// 과제1 : 날짜 입력 유효성 체크 구현
		while(true) {
			if(day > 31 || day < 1) {
				try {
					System.out.println("입력하신 일은 없는 일입니다.");
					System.out.print("일 입력>>> ");
					day = scan.nextInt();
					break;
				} catch (Exception e) {
					scan.next();
				}
			} else {
				break;
			}
		}
		
		int total = 0;
		System.out.printf("%d월은 %d일까지입니다.\n", month, days[month-1]);
		
		for(int i = 0; i < days.length; i++) {
			total = total + days[i];
		}
		System.out.printf("1년은 %d일입니다.\n", total);
		
		
		// 1월 1일부터 입력받은 월/일 까지 몇일이 지났는가?
		total = day;
		for(int i = 0; i < month - 1; i++) {
			total += days[i];
		}
		System.out.printf("1월 1일부터 %d월 %d일까지는 %d일이 지났습니다.\n", month, day, total);
		System.out.println();
		
		// 과제2 : 0월 0일 부터 1년의 남은 날짜는 00일 입니다.
		// 365 - total 빼기 금지
		total = days[month - 1] - day;
		for(int i = month; i < days.length; i++) {
			total += days[i];
		}
		System.out.printf("%d월 %d일부터 1년의 남은 날짜는 %d일입니다.\n", month, day, total);
		System.out.println();

		// 과제3 : 입력 월/일의 100일 후의 날짜 출력
		int month2 = month;
		int day2 = day;
		
		for(int i = 0; i < 100; i++) {
			day2 += 1;
			if(day2 > days[month2 - 1]) {
				day2 = 1;
				month2 += 1;
				if(month2 > 12) {
					month2 = 1;
				}
			}
		}
		System.out.printf("%d월 %d일부터 100일 후의 날짜는 %d월 %d일입니다.\n", month, day, month2, day2);
		System.out.println();
		
/*		// 입력 월/일의 30일 후의 날짜 출력
		int month2 = month;
		int day2 = day + 30;
		
		for(int i = 0; i < days.length; i++) {
			if (day2 > days[i]) {
				day2 = days[i+1] - day;
				month2 = month + 1;
				if(month2 > 12) {
					month2 = month2 - 12;
				}
			}
			System.out.printf("%d월 %d일부터 30일 후의 날짜는 %d월 %d일입니다.\n", month, day, month2, day2);
			break;
		}
*/		
		// 과제4 : 확장 해보기 - 100일 후의 날짜를 200일 300일 특정 날수 적용되게 하기
		System.out.print("특정 일를 입력하세요 >> ");
		int num = scan.nextInt();
		int month3 = month;
		int day3 = day;
		
		for(int i = 0; i < num; i++) {
			day3 += 1;
			if(day3 > days[month3 - 1]) {
				day3 = 1;
				month3 += 1;
				if(month3 > 12) {
					month3 = 1;
				}
			}
		}
		System.out.printf("%d월 %d일부터 %d일 후의 날짜는 %d월 %d일입니다.\n", month, day, num, month3, day3);
	}

}
