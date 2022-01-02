package Ch05_실습문제풀이_3;

// 실습문제 5번 ~ 8번

public class Point {
	private int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	protected void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
