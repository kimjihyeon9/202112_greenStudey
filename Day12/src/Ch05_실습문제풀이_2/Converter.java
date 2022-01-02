package Ch05_실습문제풀이_2;

import java.util.Scanner;

// 실습문제 3번

public abstract class Converter {
	protected abstract double convert(double src);
	protected abstract String getSrcString();
	protected abstract String getDestString();
	protected double ratio;

	public void run() {
		Scanner scan = new Scanner(System.in);

		System.out.printf("%s을 %s로 바꿉니다.\n", getSrcString(), getDestString());
		System.out.printf("%s을 입력하세요>> ", getSrcString());
		double val = scan.nextDouble();
		double res = convert(val);
		System.out.printf("변환 결과: %.2f%s 입니다.\n", res, getDestString());

		scan.close();
	}
}