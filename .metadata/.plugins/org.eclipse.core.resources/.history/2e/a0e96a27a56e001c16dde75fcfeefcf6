package Ch08_04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ch08_실습문제 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		File file = new File("C:\\temp\\phone.txt");
		FileWriter writer = new FileWriter(file);
		
		System.out.println("전화번호 입력 프로그램입니다.");
		while(true) {
			System.out.print("이름 전화번호 >> ");
			String s = scan.nextLine();
			if("그만".equals(s)) {
				System.out.println("C:\\temp\\phone.txt에 저장하였습니다.");
				break;
			}
			writer.write(s);
			
		}
		writer.close();
		
		
	}
}
