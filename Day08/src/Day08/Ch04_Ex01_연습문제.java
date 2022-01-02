package Day08;

// 6번
class TV{
	private int size;
	private String manufacturer;
	public TV() {
		this(32, "LG");
		System.out.println(size + "인치 " + manufacturer);
	}
	public TV(String manufacturer) {
		this(32, manufacturer);
		System.out.println(size + "인치 " + manufacturer);
	}
	public TV(int size, String manufacturer) {
		this.size = size;
		this.manufacturer = manufacturer;
		System.out.println(size + "인치 " + manufacturer);
	}
}

// 7번
class Person{
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

// 8번
class Power{
	private int kick;
	private int punck;
	
	public int getKick() {
		return kick;
	}
	public void setKick(int kick) {
		this.kick = kick;
	}
	public int getPunck() {
		return punck;
	}
	public void setPunck(int punck) {
		this.punck = punck;
	}
}

//s = new String("Hello" + n);

// 13번
//class Test{
//	public int f(int a, int b) {
//		return a + b;
//	}
//	public static void main(String [] args) {
//		int sum = f(2, 4);
//	}
//}

public class Ch04_Ex01_연습문제 {
	
	public static void main(String[] args) {
		Power robot = new Power();
		robot.setKick(10);
		robot.setPunck(20);
	}

}
