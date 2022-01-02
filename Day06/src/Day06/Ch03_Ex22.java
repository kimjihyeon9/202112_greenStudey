package Day06;

import java.util.Arrays;

public class Ch03_Ex22 {
	public static void main01(String[] args) {
//		String[] names; // 4바이트짜리 참조변수 만든거
		String[] names = {"오징어", "꼴뚜기", "대구", "명태", "거북이"}; // 배열과 동시에 초기화 시켜준거
		int[] price = {9000, 3000, 5000, 6000, 20000};
		
		for(int i = 0; i < names.length; i++) {
			System.out.printf("%s의 가격은 %d원입니다\n", names[i], price[i]);
		}
	}
	
	public static void main02(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		
		// 순서대로 출력하기
//		for(int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
		
		// Arrays 를 이용해서 순서대로 출력하기
		System.out.println(Arrays.toString(arr));
		
		// 반복문을 이용해서 arr배열의 요소값을 위치를 reverse 한다 (치환을 해야한다고 생각해야한다)
		// [50, 40, 30, 20, 10]
		for(int i = 0, end = arr.length - 1; i < arr.length / 2; i++) {
			int a = arr[i];
			arr[i] = arr[end - i];
			arr[end - i] = a;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void reverse(int[] arr) { // reverse를 함수로 만들어서 사용
		// 반복문을 이용해서 arr배열의 요소값을 위치를 reverse 한다 (치환을 해야한다고 생각해야한다)
		// [50, 40, 30, 20, 10]
		for(int i = 0, end = arr.length - 1; i < arr.length / 2; i++) {
			int a = arr[i];
			arr[i] = arr[end - i];
			arr[end - i] = a;
		}
	}
	
	public static void main_reverseTest(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		System.out.println(Arrays.toString(arr));
		reverse(arr); // 콜 바이 레퍼런스
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main03(String[] args) { // sort
		// 선택정렬
		// 		이중for문으로 한다
		
//		삽입정렬(책장 정렬), 버블정렬(물방울 정렬)을 공부하기
		
		int[] arr = {7, 3, 2, 8, 1, 6, 9, 4, 5};
		// 오름차순 정렬해서 출력하기 (선택정렬)
		// [1, 2, 3, 4, 5, 6, 7, 8, 9]
		
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) { // 부등호 반대로 하면 내림차순
					int a = arr[i];
					arr[i] = arr[j];
					arr[j] = a;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main_lotto(String[] args) {
		final int SIZE = 6;
		int[] lotto = new int[SIZE];
		// Math.random() = 1보다 작은 난수, 1보다 큰 수를 출력하고싶으면 * 이용
		// 로또번호가 중복 없이 나오도록 개선하기
		int num = (int) (1 + Math.random() * 6);
		
		// 이중for문으로 해보기 1
//		for(int i = 0; i < SIZE; i++) {
//			num = (int) (1 + Math.random() * 45);
//			lotto[i] = num;
//			for(int j = 0; j < i; j++) { 
//				if(lotto[i] == lotto[j]) {
//					i--;
//				} 
//			}
//		}
//		System.out.println(Arrays.toString(lotto));


		// 실행은 안된다 로직만 이해했음... 
/*		for(int i = 0; i < SIZE; i++) {
			lotto[0] = num;
			int equal = 0;
			for(int j = 0; j < i; j++) {
				if(lotto[j] == num) {
					equal++;
//					equal = equal + 1;
				}
			}
			if(equal == 0) {
				lotto[i] = num;
			} else {
				i--;
			}
		}
		System.out.println(Arrays.toString(lotto));
*/
		// while로 해보기
//		int i = 0;
//		int j = 0;
//		
//		while(i < SIZE) {
//			lotto[i] = num;
//			for(j = 0; j < i; j++) {
//				if(lotto[j] == num) {
//					i--;
//				}
//			}
//			continue;
//		}
//		System.out.println(Arrays.toString(lotto));

	}
	
	public static void main_lotto_1(String[] args) {
		final int SIZE = 6;
		int[] lotto = new int[SIZE];
		
		for(int i = 0; i < SIZE; i++) {
			int num = (int) (1 + Math.random() * 45);
			// 새로 생성한 num의 값과 lotto 배열에 저장된 요소를 비교한다
			// --> num과 같은 값이 이미 있다면 새로 다시 num을 생성한다
			// 새로 다시 생성한 num과 lotto의 요소를 비교한다.(계속반복) - while문을 써도 가능할듯
			for(int j = 0; j < i; i++) {
				if(num == lotto[j]) {
					num = (int) (1 + Math.random() * 45);
					j = -1;
				}
			}
			lotto[i] = num;
		}
		System.out.println(Arrays.toString(lotto));
	}
	
	public static void main_lotto_2(String[] args) {
		final int SIZE = 6;
		int[] lotto = new int[SIZE];
		
		int cnt = 0;
		while(cnt < 6) {
			lotto[cnt] = (int) (1 + Math.random() * 45);
			boolean flag = true;
			for(int i = 0; i < cnt; i++) {
				if(lotto[cnt] == lotto[i]) {
					break;
				}
			}
			if(flag) cnt++;
		}
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
	}
	
	public static void main(String[] args) {
		final int MAX = 6;
		int[] lotto = new int[MAX];
		int[] balls = new int[45];
		
		for(int i = 1; i <= 45; i++) {
			balls[i - 1] = i;
		}
		// 1~45 까지의 공이 준비됨
//		System.out.println(Arrays.toString(balls));
		
		// 1. balls의 index를 랜덤하게 선택한다
		// 2. 그 선택한 index 위치의 번호가 0이 아니면 lotto 배열에 추가한다
		// 3. 뽑아온 index 위치의 요소 값을 0으로 변경.
		// 4. index위치의 값이 0이면 다른 랜덤한 index 선택 (끝까지 반복)
		
		for(int i = 0; i < lotto.length; ) {
			int index = (int)(Math.random() * 45); // 0~44까지의 난수 발생
			if(balls[index] != 0) {
				lotto[i] = balls[index];
				balls[index] = 0;
				i++;
			}
		}
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
		
	}
}
