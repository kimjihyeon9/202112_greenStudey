package Ch07_1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

class Student {
	private String name;
	private String subject;
	private String number;
	private double sjAvg;
	
	public Student() {
		this("", "", "", 0);
	}
	
	public Student(String name, String subject, String number, double sjAvg) {
		this.name = name;
		this.subject = subject;
		this.number = number;
		this.sjAvg = sjAvg;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "이름: " + name + "\n학과: " + subject + "\n학번" + number + "\n학점평균: " + sjAvg;
	}

	public String toString(int i) {
		return name + ", " + subject + ", " + number + ", " + sjAvg;
	}
}

public class Ch07_실습문제5번_준비 {
	public static Scanner scan = new Scanner(System.in);
	public static HashMap<String, Student> smap = new HashMap<String, Student>();
	
	public static void main(String[] args) {
		run();
	}

	private static void run() {
		System.out.println("학생 이름, 학과, 학번, 학점평균 입력하세요.");
		for(int i = 0; i < 4; i++) {
			System.out.print(">> ");
			String info = scan.nextLine();
			StringTokenizer st = new StringTokenizer(info, ",");
			String name = st.nextToken();
			String subject = st.nextToken();
			String number = st.nextToken();
			double sjAvg = Double.parseDouble(st.nextToken());
			
			smap.put(name, new Student(name, subject, number, sjAvg));
		}
		Set<String> ss = smap.keySet();
		Iterator<String> it = ss.iterator();
		while(it.hasNext()) {
			System.out.println("-----------------------");
			System.out.println(smap.get(it.next()).toString());
		}
		System.out.println();
		
		System.out.println("검색할 이름을 입력해주세요.");
		System.out.println("(그만 입력시 종료)");
		while(true) {
			System.out.print("학생이름>> ");
			String name = scan.next();
			if("그만".equals(name)) {
				break;
			}
			
			if(smap.get(name) != null) {
				System.out.println(smap.get(name).toString(0));
			} else {
				System.out.println("찾는 학생은 없습니다.");
			}
			System.out.println();
		}
		System.out.println("프로그램 종료");
		scan.close();
	}

}
