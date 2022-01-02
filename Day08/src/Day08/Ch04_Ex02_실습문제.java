package Day08;

import java.util.Scanner;

//class TV{ // main01의 생성자
//	private String m;
//	private int year;
//	private int size;
//	
//	TV(String m,int year, int size) {
//		this.size = size;
//		this.year = year;
//		this.m = m;
//	}
//	
//	public void show() {
//		System.out.println(m + "에서 만든 " + year + "년형 " + size + "인치 TV");
//	}
//}

class Grade { // main02의 생성자
	private int math;
	private int science;
	private int english;

	public Grade(int math, int science, int english) {
		this.math = math;
		this.science = science;
		this.english = english;
	}

	public int average() {
		return (math + science + english) / 3;
	}
}

class Song{ // main03의 생성자
	private String title;
	private String artist;
	private int year;
	private String country;
	
	Song(String title, String artist, int year, String contry){
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = contry;
	}
	
	public void show() {
		System.out.printf("%d년 %s국적의 %s가 부른 %s", year, country, artist, title);
	}
}

class Rectangle{ // main04의 생성자
	private int x, y, width, height;
	
	 public Rectangle(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public int square() {
		return width * height;
	}
	
	public void show() {
		System.out.printf("(%d, %d)에서 크기가 %dx%d인 사각형\n", x, y, width, height);
	}
	
	public boolean contains(Rectangle r) {
		if(x < r.x && y < r.y) {
			if((width + x) > (r.x + r.width) && (height + y) > (r.y + r.height)) {
				return true;
			}
		}
		return false;
	}
}

class Circle{ // main05의 생성자
	private double x, y;
	private int radius;
	
	public Circle(double x, double y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public void show() {
		System.out.printf("(%.1f, %.1f)%d\n", x, y, radius);
	}
}

class Circle2{ // main06의 생성자
	private double x, y;
	private int radius;
	
	public Circle2(double x, double y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public double size() {
		return radius;
	}
	
	public void show() {
		System.out.printf("(%.1f, %.1f)%d\n", x, y, radius);
	}
}

class Day{
	private String work;
	
	public void set(String work) { 
		this.work = work; 
	}
	
	public String get() { 
		return work; 
	}
	
	public void show() {
		if(work == null) 
			System.out.println("없습니다.");
		else 
			System.out.println(work + "입니다.");
	}
}

class MonthSchedule {
	// 생성자, input(), view(), finish(), run()
	private String work;
	
	public MonthSchedule(String work) {
		this.work = work;
	}
	
	public void input() {
		
	}
	
	public void view() {
		
	}
	
	public void finish() {
		
	}
	
	public void run() {
		
	}
}

public class Ch04_Ex02_실습문제 {
	
	public static void main01(String[] args) {
//		TV myTV = new TV("LG", 2017, 32);
//		myTV.show();
	}

	public static void main02(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력>> ");
		int math = scanner.nextInt();
		int science = scanner.nextInt();
		int english = scanner.nextInt();
		Grade me = new Grade(math, science, english);
		System.out.println("평균은 " + me.average());
		
		scanner.close();
	}
	
	public static void main03(String[] args) {
		Song s = new Song("Dancing Queen", "ABBA", 1978, "스웨덴");
		s.show();
	}
	
	public static void main04(String[] args) {
		Rectangle r = new Rectangle(2, 2, 8, 7);
		Rectangle s = new Rectangle(5, 5, 6, 6);
		Rectangle t = new Rectangle(1, 1, 10, 10);
		
		r.show();
		System.out.println("s의 면적은 " + s.square());
		if(t.contains(r)) System.out.println("t는 r을 포함합니다");
		if(t.contains(s)) System.out.println("t는 s을 포함합니다");
	}
	
	public static void main05(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Circle c [] = new Circle[3];
		for(int i = 0; i < c.length; i++) {
			System.out.print("x, y, radius >> ");
			double x = scanner.nextDouble();
			double y = scanner.nextDouble();
			int radius = scanner.nextInt();
			c[i] = new Circle(x, y, radius);
		}
		for(int i = 0; i < c.length; i++) c[i].show();
		scanner.close();
	}

	public static void main06(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Circle2 c [] = new Circle2[3];
		for(int i = 0; i < c.length; i++) {
			System.out.print("x, y, radius >> ");
			double x = scanner.nextDouble();
			double y = scanner.nextDouble();
			int radius = scanner.nextInt();
			c[i] = new Circle2(x, y, radius);
		}
		int max = 0;
		for(int i = 0; i < c.length; i++) {
			if(c[max].size() < c[i].size()) {
				max = i;
			}
		}
		System.out.print("가장 면적인 큰 원은 ");
		c[max].show();
		scanner.close();
	}
	
	public static void main(String[] args) {
//		MonthSchedule april = new MonthSchedule(30); // 4월달의 할일
//		april.run();
	}
}












