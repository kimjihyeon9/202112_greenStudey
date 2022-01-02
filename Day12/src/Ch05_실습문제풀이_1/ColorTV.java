package Ch05_실습문제풀이_1;

// 실습문제 1번

class TV{ // super클래스
	private int size;
	
	public TV(int size) {
		this.size = size;
	}
	
	protected int getSize() {
		return size;
	}
}

public class ColorTV extends TV {
	private int color;
	public ColorTV(int size, int color) {
		super(size);
		this.color = color;
	}
	
	public void printProperty() {
		System.out.printf("%d인치 %d컬러\n", getSize(), color);
	}

	public static void main(String[] args) {
		ColorTV myTV = new ColorTV(32, 1024);
		myTV.printProperty();
	}

}
