package Ch08_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ch08_Ex01_1 {
	public static void main(String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(is);
		
		System.out.print("이름 입력 : ");
		String name = b.readLine();
		
		System.out.print("주소 입력 : ");
		String addr = getLine();

		System.out.print("나이 입력 : ");
		int age = getNum();
		
		System.out.println("입력하신 이름은 " + name);
		System.out.println("입력하신 주소은 " + addr);
		System.out.println("입력하신 나이은 " + age);
	}

	public static String getLine() { // 문자열 입력받음
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(is);
		
		try {
			return b.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int getNum() { // 숫자 입력받음
		String s = getLine();
		StringBuffer s2 = new StringBuffer();
		
		for(int i = 0; i <s.length(); i++) {
			char ch = s.charAt(i);
			if(ch > '0' && ch < '9') {
				s2.append(ch);
			}
		}
		return Integer.parseInt(s);
	}
}













