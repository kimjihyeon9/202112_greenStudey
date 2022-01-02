package Day13;

import java.util.Scanner;

public class Ch03_Ex04_구구단출력 {
	
	public static void main01(String[] args) {
		// 구구단 출력 프로그램
		// 2단~9단까지 출력하는 프로그렘 구현
		
		for(int dan = 2; dan <= 9; dan += 1) {
			System.out.printf("***%d***\n", dan);
			for(int cnt = 1; cnt <= 9; cnt = cnt + 1) {
				System.out.printf("%d * %d = %d", dan, cnt, dan*cnt);
			}
		}
		
		// 내가 한거
/*		for(int i = 2; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d", i, j, i*j);
				System.out.print("\n");
			}
			System.out.println("\t");
		}
*/
	}
	
	public static void main02(String[] args) {
		// 2중 for문 실행 전에 제목이 한줄로 출력 되도록 한다
		for(int title = 2; title <= 9; title++) {
			System.out.printf("***%d***\t\t", title);
		}
		System.out.println();
		for(int cnt = 1; cnt <= 9; cnt = cnt + 1) {
			for(int dan = 2; dan <= 9; dan += 1) {
				System.out.printf("%d * %d = %d\t", dan, cnt, dan*cnt);
			}
			System.out.println();
		}
	}
	
	static Scanner scan = new Scanner(System.in);

	static int getDan(String message) {
		System.out.print(message);
		int dan = scan.nextInt();
		// 유효성 검사
		while(dan < 2 || dan > 9) {
			System.out.println("입력 범위를 초과했습니다.");
			System.out.print(message);
			dan = scan.nextInt();
		}
		return dan;
	}
	
	public static void main03(String[] args) {
		int startDan = 2;
		int endDan = 9;
		
		startDan = getDan("시작단 입력>> ");
		endDan = getDan("종료단 입력>> ");
		
		// 시작단이 종료단 보다 큰 숫자여도 정상 출력 되도록 완성하기
		// 치환하기
		if (startDan > endDan) {
			int a = startDan;
			startDan = endDan;
			endDan = a;
		}
		
		for(int cnt = 1; cnt <= 9; cnt = cnt + 1) {
			System.out.println("");
//			System.out.printf("***%d***\n", dan);
			for(int dan = startDan; dan <= endDan; dan++) {
				System.out.printf("%d * %d = %d\t", dan, cnt, dan*cnt);
			}
		}
	}
	
	public static void main04(String[] args) {
		// 과제1 : 3행 3열로 구구단 출력
		// 과제2 : 시작단, 종료단 기능과 합체하세요
		
		int dan = 2;
		
		for(dan = 2; dan <= 9; dan += 1) {
			for(int cnt = 1; cnt <= 9; cnt = cnt + 1) {
				for(int i = 0; i < 3; i++) {
					if(dan+i != 10) {
						System.out.printf("***%d***\t", dan + i);
					}
				}
				System.out.printf("%d * %d = %d\t", dan, cnt, dan*cnt);
				}
			System.out.println();
		}
		
//		for(int dan = 2; dan <= 9; dan += 3) {
//			for(int i = 0; i < 3; i++) {
//				if(dan+i != 10) {
//					System.out.printf("***%d***\t", dan + i);
//				}
//			}
//			System.out.println();
//		}
		
	}
	public static void main0401(String[] args) {
		// 과제1 : 3행 3열로 구구단 출력
		
		for(int dan = 2; dan < 10; dan+=3) {
			for(int j = 0; j < 3; j++) {
				if(dan+j != 10) {
					System.out.printf("----%d----\t", dan+j);
				}
			}
			System.out.println();
			
			for(int cnt = 1; cnt < 10; cnt++) {
				for(int i = 0; i < 3; i++) {
					if(dan+i != 10) {
						System.out.printf("%d * %d = %d\t", dan+i, cnt, (dan+i)*cnt);
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// 과제2 : 시작단, 종료단 기능과 합체하세요
		
		int startDan = 2;
		int endDan = 9;
		
		startDan = getDan("시작단 입력>> ");
		endDan = getDan("종료단 입력>> ");
		
		if (startDan > endDan) {
			int a = startDan;
			startDan = endDan;
			endDan = a;
		}
		
		for(int dan = startDan; dan <= endDan; dan+=3) {
			for(int j = 0; j < 3; j++) {
				if(dan+j < endDan+1) {
					System.out.printf("----%d----\t", dan+j);
				}
			}
			System.out.println();
			
			for(int cnt = 1; cnt <= 9; cnt++) {
				for(int i = 0; i < 3; i++) {
					if(dan+i < endDan+1) {
						System.out.printf("%d * %d = %d\t", dan+i, cnt, (dan+i)*cnt);
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}

// ------코딩 못하는 사람의 특징--------
// 1. 빨간 글자를 일기 싫어한다
// 2. 테스트를 하지 않는다.
// 3. 생각을 안하고 습관적으로 코딩한다
// 4. 영타가 느리다.
// 5. 선생님을 이유없이 싫어한다.
