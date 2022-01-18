package ex01_socketIO_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientEx01 {
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	Scanner scan = new Scanner(System.in);
	
	public ClientEx01() {
		try {
			socket = new Socket(InetAddress.getLocalHost(), 9999);
			System.out.println("클라이언트>>> 서버와 연결되었습니다");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			bw.write("user01" + "\n");
			bw.flush();
			
			while(true) {
				String line = scan.nextLine();
				bw.write(line + "\n");
				bw.flush();
				
				String serverMessage = br.readLine();
				System.out.println(serverMessage);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ClientEx01();
	}

}
