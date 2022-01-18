package ex01_socketIO;

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
			// ServerSocket을 생성하고
			listener = new ServerSocket(9999); // 서버소켓 만들어짐, 일회용이다
			System.out.println("서버 >>> 서버 대기중 ...");
			
			// 클라이언트 접속 대기 - 접속이 되면 Socket을 반환한다.
			socket = listener.accept();
			System.out.println("서버 >>> 클라이언트와 접속이 되었습니다~");
			
			// 클라이언트와 입/출력 스트림을 연결한다
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			// 클라이언트의 userId를 읽어오기
			try {
				// 라인의 '\n'이다. '\n'이 없는 데이터는 readLine()로 읽을 수 없다
				String userId = br.readLine(); 
				System.out.println("서버 >>> " + userId + "님이 접속 하였습니다!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			while(true) {
				// 반복해서 읽어들인다
				String line = br.readLine();
				System.out.println(">>> " + line);
				
				// 클라이언트로 다시 전송(에코)
				bw.write("Server>>> " + line + "\n");
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Socket Server
		new ServerEx01();
	}

}
