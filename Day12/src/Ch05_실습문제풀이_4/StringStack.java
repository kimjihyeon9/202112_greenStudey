package Ch05_실습문제풀이_4;

import java.util.Scanner;

// 실습문제 9번

interface Stack {
	int length(); // 현재 스택에 저장된 개수 리턴
	int capacity(); // 스택의 전체 저장 가능한 개수 리턴
	String pop(); // 스택의 top에 실수 저장
	boolean push(String val); // 스택의 top에 저장된 실수 리턴
}

public class StringStack implements Stack {
	private String[] stack;
	private int top;

	public StringStack(int capacity) {
		stack = new String[capacity];
		top = 0;
	}

	@Override
	public int length() { // top
		return top;
	}

	@Override
	public int capacity() { // 배열의 size
		return stack.length;
	}

	@Override
	public String pop() {
		if(top-1 < 0) {
			return null;
		}
		return stack[--top];
	}

	@Override
	public boolean push(String val) {
		if(top >= capacity()) {
			return false;
		}
		stack[top++] = val;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("총 스택 저장 공간의 크기 입력 >> ");
		int capacity = scan.nextInt();
		
		StringStack stack = new StringStack(capacity);
		while(true) {
			System.out.print("문자열 입력 >> ");
			String str = scan.next();
			if(!stack.push(str)) {
				System.out.println("스택이 꽉 차서 푸시 불가!");
				break;
			}
		}
		scan.close();
		
		System.out.print("스택에 저장된 모든 문자열 팝 : ");
		while(true) {
			String str = stack.pop();
			if(str == null) {
				break;
			}
			System.out.print(str + " ");
		}
		System.out.println();
	}

}
