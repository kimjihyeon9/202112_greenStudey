package Ch05_실습문제풀이_2;

//실습문제 3번

public class Won2Dollar extends Converter {
	
	private String srcString = "원";
	private String destString = "달러";
	
	public Won2Dollar(double ratio) {
		super.ratio = ratio;
	}

	@Override
	protected double convert(double src) {
		return src / ratio;
	}

	@Override
	protected String getSrcString() {
		return srcString;
	}

	@Override
	protected String getDestString() {
		return destString;
	}
	
	public static void main(String[] args) {
		Won2Dollar toDollar = new Won2Dollar(1200);
		toDollar.run();
	}

}
