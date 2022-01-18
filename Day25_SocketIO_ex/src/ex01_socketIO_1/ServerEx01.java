package ex01_socketIO_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx01 {
	ServerSocket listener = null;
	
	public ServerEx01() {
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			listener = new ServerSocket(9999);
			System.out.println("서버>>> 서버 대기중 ...");
			
			socket = listener.accept();
			System.out.println("서버>>> 클라이언트와 접속이 되었습니다");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String userId = br.readLine();
			System.out.println("서버>>> " + userId + "님이 접속 하였습니다");
			
			while(true) {
				String line = br.readLine();
				System.out.println(">>>" + line);
				
				bw.write("서버>>> " + line + "\n");
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ServerEx01();
	}

}
