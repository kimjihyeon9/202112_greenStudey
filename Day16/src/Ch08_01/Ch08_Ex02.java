package Ch08_01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Ch08_Ex02 {
	public static void main01(String[] args) throws IOException {
		OutputStream os = System.out; // 업캐스팅
		byte[] by = new byte[255];
		
		System.out.print("문자 입력 >> ");
		System.in.read(by);
		
		String s = new String(by).trim();
		
		os.write(s.getBytes());
	}

	public static void main02_1(String[] args) throws IOException {
		OutputStream os = System.out;
		InputStream is = System.in;
		
//		int data = is.read(); // 바이트코드로 받는다(아스키코드) a(97), A(65), 0(48), \n(13)
//		System.out.println(data);
		
		System.out.println("데이터를 입력 해 보세요. (끝내려면 Ctrl+z) : ");
		int data = 0;
		while((data = is.read()) != -1) { // EOF(End Of File)일때까지 (Ctrl + z)
			os.write(data);
		}
		System.out.println("입력 종료!");
	}

	public static void main02_2(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\data.txt");
		InputStream is = System.in;
		
		System.out.println("데이터를 입력 해 보세요. (끝내려면 Ctrl+z) : ");
		int data = 0;
		while((data = is.read()) != -1) { // EOF(End Of File)일때까지 (Ctrl + z)
			fos.write(data);
		}
		System.out.println("입력 종료!");
		fos.close(); 
		
		// 파일을 열었으면 반드시 닫아야한다
		// 안닫으면 계속 열려있어서 기록이 안된다
	}
	
	public static void main03(String[] args) throws IOException {
		// 파일에서 데이터 읽어오기
		// InputStream is = System.in;
		File file = new File("C:\\Users\\Administrator\\data.txt");
		FileInputStream is = new FileInputStream(file);
		
		int data = 0;
		while((data = is.read()) != -1) {
			System.out.write(data);
		}
		is.close();
		System.out.println("파일 읽기 완료!");
	}
	
	public static void main04(String[] args) throws IOException {
		// File
		// 크롤링 : 웹 페이지를 복사하는것
		File file = new File("C:\\Users\\Administrator\\test_myfile.txt");
		if(file.exists()) {
			System.out.println(">> 있다!");
			if(file.isDirectory()) {
				String[] fileList = file.list(); // 파일의 목록을 가지고온다
				for(String fileName : fileList) {
					System.out.println(fileName);
				}
			} else {
				if(file.delete()) {
					System.out.println(">> 파일이 삭제 됨!");
				}
			}
		} else {
			System.out.println(">> 없다!");
			if(file.createNewFile()) {
				System.out.println("파일이 생성 되었습니다.");
			}
		}
	}
	
	public static void main05(String[] args) throws FileNotFoundException { // Scanner 사용해서 읽어올수있다
		File file = new File("C:\\Users\\Administrator\\data.txt");
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}
	}
	
	public static void main06(String[] args) throws IOException { // BufferedReader사용해서도 읽어올수있다
		File file = new File("C:\\Users\\Administrator\\data.txt");
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		
		String s = null;
		while((s = br.readLine()) != null) {
			System.out.println(s);
		}
	}
	
	public static void main07(String[] args) throws IOException {
		// 키보드로 데이터를 입력 받아서 fw를 이용해서 data2.txt파일에 기록하기
		File file = new File("C:\\Users\\Administrator\\data2.txt");
		FileWriter fw = new FileWriter(file); // 한줄만 쓸수있다
		
		System.out.println("내용을 입력하세요.");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		fw.write(s);
		
		fw.close();
	}
	
	public static void main08(String[] args) throws IOException {
		File file = new File("C:\\Users\\Administrator\\data2.txt");
		FileReader fr = new FileReader(file);
		
		char[] cbuf = new char[255];
		fr.read(cbuf);
		
		System.out.println(new String(cbuf).trim());
		
		fr.close();
	}
	
	public static void main_dis(String[] args) throws IOException {
		// DataInputStream
		File file = new File("C:\\Users\\Administrator\\data2.txt"); // 파일가져오기
		FileInputStream fis = new FileInputStream(file); 
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis); 
		
		String s = null;
		try {
			s = dis.readUTF(); // UTF로 기록된 데이터를 읽어온다
			System.out.println(s);
		} catch (IOException e) {
			System.out.println("UTF 읽기 오류 발생");
		} finally {
//			System.out.println(s);
			dis.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		// UTF로 기록하고
		File file = new File("C:\\Users\\Administrator\\data2.txt");
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("저장 할 문장을 입력 하세요.");
		String ins = null;
		StringBuffer stringData = new StringBuffer();
		
		while((ins = br.readLine()) != null) {
			if(ins.equals("그만")) break;
			stringData.append(ins);
			stringData.append("\n");
		}
		
		dos.writeUTF(stringData.toString());
		
		dos.close();
		
		// UTF읽기 호출
		main_dis(null);
	}
	
	// 객체를 파일에 저장하고 객체로 읽어온다
	// 자바는 객체지향 언어이므로 객체 저장이 더 효과적이다
	// 객체 직렬화 : 객체를 저장하고 읽을때 필요한 개념.
	// 만약 객체를 집에 비유한다면 안동 하혜마을에 있는 집들은 안동댐이 만들어지면서 침수될 집들을 뜯어다가 민속촌에다가 옮겨놓은거다
}






















