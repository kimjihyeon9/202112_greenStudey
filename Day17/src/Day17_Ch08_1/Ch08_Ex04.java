package Day17_Ch08_1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ch08_Ex04 {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Windows\\systeam.ini");
		Scanner scan = new Scanner(new FileReader(file));
		
		int lineNumber = 1;
		while(scan.hasNext()) {
			String line = scan.nextLine();
			System.out.println(line);
		}
	}

}
