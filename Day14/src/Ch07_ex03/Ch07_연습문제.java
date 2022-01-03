package Ch07_ex03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class Ch07_연습문제 {
/*	1. 3번
	
	2. 클래스, 인터페이스, 메소드를 특정 타입에 종속되지 않게 일반화시켜 작성하는 기술을 제네릭이라 한다.
	Vector<E>에서 E는 제네릭 타입 혹은 타입 매개변수 라고 부른다.
	E에 Integer 등과 같이 객체 타입을 지정하여 특정 타입의 데이터만 다루도록 만드는 작업을 구체화라고 한다.
	제네릭 기능은 C++에서 먼저 만들어졌으며 C++에서는 템플릿이라고 부른다
	
	3. 2번
	
	5. 1번
	
	6. 자동 박싱 : v.add(3.14); 자동 언박싱 : double d = v.get(0);
	
	7. 12, for문을 돌면서 부족해진 용량이 2배로 늘어난다
	
	

*/
	public static <Person> void main04(String[] args) {
		Vector<String> sv = new Vector<String>();
		HashMap<String, Double> h = new HashMap<String, Double>();
		ArrayList<Person> pa = new ArrayList<Person>(10);
		HashMap<String, Integer> pop = new HashMap<String, Integer>();
	}
	
	public static void main07(String[] args) {
		Vector<Integer> v = new Vector<Integer>(3);
		for(int i = 0; i < 10; i++) {
			v.add(i);
		}
		System.out.println(v.capacity());
	}
	
	public static void main08(String[] args) {
		ArrayList<String> a = new ArrayList<String>(10);
		a.add("Java");
		a.add(0, "C++");
		System.out.println(a.size());
		a.remove(a.size() - 1);
		System.out.println(a.size());
	}
	
	public static void main09(String[] args) {
//		Vector<Integer> v = new Vector<Integer>();
//		for(int i = 0; i < 10; i++) {
//			v.add(i);
//		}
//		for(int i = 0; i < v.size(); i++) {
//			System.out.print(v.get(i) + " ");
//		}
		
		Vector<Integer> v = new Vector<Integer>();
		for(int i = 0; i < 10; i++) {
			v.add(i);
		}
		Iterator<Integer> it = v.iterator();
		while(it.hasNext()) {
			int n = it.next();
			System.out.print(n + " ");
		}
	}
	
	public static void main10(String[] args) {
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		h.put("a", 10);
		h.put("b", 20);
		System.out.println(func(h));
	}
	private static int func(HashMap<String, Integer> h) {
		return h.size() ;
	}

	class JGeneric<W> {
		private W x, y;
		public JGeneric(W x, W y) {
			this.x = x;
			this.y = y;
		}
		// (3)
		public W first() {
			return x;
		}
		// (4)
		public W second() {
			return y;
		}
		// (5)
		public boolean equal() {
			if(x.equals(y)) 
				return true;
			else
				return false;
		}
	}
	public static void main11(String[] args) {
		// (1) 1개, W
		// (2)
//		JGeneric<String> jg = new JGeneric<String>("hello", "hellw");
		// (6)
//		System.out.println(jg.first());
//		System.out.println(jg.second());
//		System.out.println(jg.equal());
		
	}
	
	public static void main12(String[] args) {
		class JClass {
			<T> T take(T s[], int index) {
				if(index > s.length) {
					System.out.println("인덱스가 범위를 벗어났습니다.");
					return null;
				}
				return s[index];
			}
		}
	}
}


















