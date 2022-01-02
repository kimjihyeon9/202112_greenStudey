package Day06;

public class Ch03_Ex21_배열요소출력 {
	public static void main(String[] args) {
		int[] arr = {10, 30, 40, 90, 120, 50};
		
		for(int number : arr) {
			System.out.println("number => " + number);
		}
		System.out.println("---------------------------------");
		
		for(int i = 0; i < arr.length; i++) { // : arr == int i = 0; i < arr.length; i++
			int number = arr[i];
			System.out.println("number => " + number);
		}
	}
}
