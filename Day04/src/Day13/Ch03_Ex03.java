package Day13;

import java.util.Scanner;

public class Ch03_Ex03 {
	static Scanner scan = new Scanner(System.in);

	public static void main00(String[] args) {
		// break label
		aaa: for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= 10; j++) {
				if(j % 3 == 0) break aaa; // break label 을 사용하게 되면 여기서 끝이난다(반복하지 않음)
				System.out.print(i * j + " ");
			}
			System.out.println();
		}
	}
	
	// break continue 응용
	public static void main(String[] args) {
		int age = 0;
		
		while(true) {
			try {
				System.out.print("나이 입력: ");
				age = scan.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("입력 실패! 다시 입력");
				scan.next(); // scan의 버퍼에서 \n을 제거한다
				continue;
			}
		}
		
		if(age < 20) {
			System.out.println("미성년자에게는 술을 팔지 않습니다.");
		} else {
			System.out.println("맛있게 드세요!");
		}
	}
}
