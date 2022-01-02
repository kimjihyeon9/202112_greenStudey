package Day09_1;

class 할배 {
	public void 나팔() {
		System.out.println("할배의 나팔 뽕!");
	}
}

class 아배 extends 할배{
	@Override
	public void 나팔() {
		System.out.println("아배의 나팔 삐리리!");
	}
}

class 손자 extends 아배{
	@Override
	public void 나팔() {
		System.out.println("손자의 나팔 뿡뿌!");
	}
}

/////////////////////////////////////////////////////////////////////////

class Shape{
	public Shape next;
	public Shape() {
		next = null;
	}
	
	public void draw() {
		System.out.println("Shape");
	}
}

class Line extends Shape {
	public void draw() {
		System.out.println("Line");
	}
}

class Rect extends Shape {
	public void  draw() {
		System.out.println("Rect");
	}
}

class Circle extends Shape {
	public void draw() {
		System.out.println("Circle");
	}
}

public class Ch05_Ex30 {

	public static void main01(String[] args) {
		할배[] family = new 할배[5];
		family[0] = new 할배();
		family[1] = new 아배();
		family[2] = new 손자();
		family[3] = new 아배();
		family[4] = new 손자();
		
		for(할배 h : family) {
			h.나팔();
		}
	}
	////////////////////////////////////////////////////////////
	
	static void paint(Shape p) {
		p.draw();
	}
	
	public static void main(String[] args) {
		Line line = new Line();
		paint(line);
		paint(new Shape());
		paint(new Line());
		paint(new Rect());
		paint(new Circle());
	}

}
