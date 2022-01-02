package miniproj;

import java.util.Scanner;

import javax.sql.rowset.serial.SerialArray;

// 고쳐야할 부분
// rank 부분 해결하지 못함 - 해결
// 수정후 sum, avg, grade 가 그대로이다 - 해결
// 삭제

class Student {
	public int no; // 번호
	public String name; // 이름
	public int kor, eng, mat;
	public int sum; // 국영수의 총점
	public double avg; // 국영수 총점의 평균
	public String grade; // 학점
	public int rank; // 등수

	public Student() {
		// 디폴트 생성자 - 인자가 없다. 아무일도 하지 않는다
	}

	public Student(int no, String name, int kor, int eng, int mat) {
//		super(); // super는 꼭 지워주기
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;

		// 총점, 평균, 학점을 만들어준다
		math();
	}

	public void math() {
		this.sum = this.kor + this.eng + this.mat;
		this.avg = this.sum / 3;

		switch ((int) this.avg / 10) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
	}

	// 객체를 사용하면 toString() 자동 호출 된다
	@Override
	public String toString() {
		math();
		return no + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + sum + "\t" + avg + "\t" + grade + "\t"
				+ rank;
	}
}

// Student st1 = new Student(); 디폴트 생성자
// st1.name = "홍길동"
// Student st2 = new Student(1, "김길동", 60, 70, 80); 오버로딩 생성자

public class MainCls_성적프로그램 {
	public static Scanner scan = new Scanner(System.in);

	public static final int MAX = 100;
	static Student[] sArr = new Student[MAX];
	static int top = 0; // 스텍 자료구조처럼.
	static int sequence = 1;

	// static 초기화 블럭
	static {
		sArr[top++] = new Student(sequence++, "KIM", 60, 60, 75);
		sArr[top++] = new Student(sequence++, "LEE", 90, 80, 80);
		sArr[top++] = new Student(sequence++, "PARK", 90, 100, 95);
		rank();
	}

	public static int menu() {
		int no = 0;

		System.out.println("1.입력 2.출력 3.검색 4.수정 5.삭제 6.종료");
		System.out.print("선택 >> ");
		no = scan.nextInt();
		// 예외처리 및 유효성 검사
		while (true) {
			if (no < 1 || no > 6) {
				System.out.println("선택하신 번호는 없는 번호입니다.");
				System.out.println("1~6 사이의 정수를 입력하세요.");
				System.out.println("1.입력 2.출력 3.검색 4.수정 5.삭제 6.종료");
				System.out.print("선택 >> ");
				no = scan.nextInt();
			} else {
				break;
			}
		}
		return no;
	}

	static int getScore(String s) {
		int score = 0;

		System.out.printf("%s 점수 >> ", s);
		score = scan.nextInt();
		while (score < 0 || score > 100) {
			System.out.println("범위를 벗어난 점수입니다.");
			System.out.println("1~100 사이의 정수를 입력해주세요.");
			System.out.printf("%s 점수 >> ", s);
			score = scan.nextInt();
		}
		return score;
	}

	static void rank() {
		for (int i = 0; i < top; i++) {
			int r = 1;
			for (int j = 0; j < top; j++) {
				if (sArr[i].sum < sArr[j].sum) {
					r++;
				}
			}
			sArr[i].rank = r;
		}
	}

	public static int indexNum(String name) {
//		name = scan.next();

		int index = -1; // sArr의 범위에 없는 숫자로 넣는것이 좋다
		for (int i = 0; i < top; i++) {
			if (name.equals(sArr[i].name)) { // true == 1
				index = i;
//				break; // 단일 if로 해서 if문의 조건을 만족하면 수행, 만족하지 못하면 아무것도 안함
			}
		}
		return index;
	}

	public static void run() {
		switch (menu()) {
		case 1:
			input();
			break;
		case 2:
			output();
			break;
		case 3:
			search();
			break;
		case 4:
			modify();
			break;
		case 5:
			delete();
			break;
		case 6:
			end();
			break;
		default:
			System.out.println("--- 해당사항 없습니다! ---");
		}
		rank();
		System.out.println("------------------------------------------");
	}

	private static void input() {
		System.out.println("::::: INPUT :::::");
		// 성명, 국어, 영어, 수학을 배열에 입력 받는다
		// 점수 예외처리 해주기 - 1~100까지의 정수 입력 받기
		// 입력 받은 국영수 점수의 총점, 평균, 학점, 등수가 만들어진다
		// 입력 된 학생의 등수가 셋팅 된다

		System.out.print("이름 >> ");
		String name = scan.next();

//		int kor = 0, eng = 0, mat = 0;
		int kor = getScore("국어");
		int eng = getScore("영어");
		int mat = getScore("수학");

		sArr[top++] = new Student(sequence++, name, kor, eng, mat);
		System.out.println("입력 성공");
	}

	private static void output() {
		System.out.println(":::::::::::::::::::::::::::::: OUTPUT ::::::::::::::::::::::::::::::");
		// 배열의 목록이 출력
		// 번호, 성명, 국어, 영어, 수학, 총점, 평균, 학점, 등수, 등수를 기준으로 정렬
		for (Student std : sArr) {
			if (std == null)
				break;
			System.out.println(std);
		}
	}

	private static void search() {
		System.out.println("::::: SEARCH :::::");
		// 이름으로 검색

		System.out.print("검색할 이름을 입력하세요 >> ");
		String keyWord = scan.next();

//		for(Student std : sArr) {
//			if(std.equals(keyWord)) {
//				System.out.println(sArr);
//			}
//		}

		int cnt = 0;
		for (int i = 0; i < top; i++) {
			if (keyWord.equals(sArr[i].name)) {
				System.out.println(sArr[i]);
				cnt++;
			}
		}
		if (cnt == 0) {
			System.out.println("찾는 정보가 없습니다.");
		}

	}

	private static void modify() {
		System.out.println("::::: MODIFY :::::");
		// 이름으로 검색 후 수정
		System.out.print("수정이 필요한 이름을 입력하세요 >> ");
		String keyWord = scan.next();
		int index = indexNum(keyWord);

		int cnt = 0;
		for (int i = 0; i < top; i++) {
			if (keyWord.equals(sArr[i].name)) {
//				System.out.println(sArr[i]);
				cnt++;
			}
		}
		if (cnt == 0) {
			System.out.println("찾는 정보가 없습니다.");
		} else {
			System.out.printf("입력하신 %s를 찾았습니다.\n", keyWord);
			System.out.println("어떤 부분을 수정할까요?");
			System.out.println("1.이름 2.국어점수 3.영어점수 4.수학점수");
			System.out.print("선택 >> ");
			int s = scan.nextInt();

			while (true) {
				if (s < 1 || s > 4) {
					System.out.println("선택하신 번호는 없는 번호입니다.");
					System.out.println("어떤 부분을 수정할까요?");
					System.out.println("1.이름 2.국어점수 3.영어점수 4.수학점수");
					System.out.print("선택 >> ");
					s = scan.nextInt();
				} else {
					break;
				}
			}

			switch (s) {
			case 1:
				System.out.println("이름을 선택하셨습니다.");
				System.out.print("변경할 이름을 입력하세요 >> ");
				String ren = scan.next();
				sArr[index].name = ren;
				System.out.println("변경되었습니다.");
				break;
			case 2:
				System.out.println("국어점수를 선택하셨습니다.");
				System.out.println("변경할 점수를 입력하세요.");
				int kor = getScore("국어");
				sArr[index].kor = kor;
				System.out.println("변경되었습니다.");
				sArr[index].math();
				break;
			case 3:
				System.out.println("영어점수를 선택하셨습니다.");
				System.out.println("변경할 점수를 입력하세요.");
				int eng = getScore("영어");
				sArr[index].eng = eng;
				System.out.println("변경되었습니다.");
				sArr[index].math();
				break;
			case 4:
				System.out.println("수학점수를 선택하셨습니다.");
				System.out.println("변경할 점수를 입력하세요.");
				int mat = getScore("수학");
				sArr[index].mat = mat;
				System.out.println("변경되었습니다.");
				sArr[index].math();
				break;
			}
		}
	}

	private static void delete() {
		System.out.println("::::: DELETE :::::");
		// 이름으로 검색후 삭제
		// 삭제할 데이터는 0이나 null을 넣어준다
		// 배열의 자리가 비었으면 뒤에서 하나씩 땡겨준다
		System.out.print("삭제가 필요한 이름을 입력하세요 >> ");
		String keyWord = scan.next();

		int cnt = 0;
		for (int i = 0; i < top; i++) {
			if (keyWord.equals(sArr[i].name)) {
				cnt++;
			}
		}
		if (cnt == 0) {
			System.out.println("찾는 정보가 없습니다.");
		} else {
			System.out.printf("입력하신 %s를 찾았습니다.\n", keyWord);
			System.out.print("찾은 정보를 삭제할까요? (y/n)");
			String tf = scan.next();
			if (tf.equals("y")) {
				System.out.println("삭제되었습니다.");
			} else {
				System.out.println("취소되었습니다.");
			}
		}
///////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.print("삭제할 이름을 입력하세요 : ");
		String deleteName = scan.next();

		for (int i = 0; i < top; i++) {
			if ((sArr[i].name).equals(deleteName)) {
				for (int j = i; j < top - 1; j++) {
					sArr[j] = sArr[j + 1];
				}
				sArr[top - 1] = null;
				top--;
			}

		}
	}

	private static void end() {
		System.out.println("::::: END :::::");
		System.out.println("프로그램 종료!");
		System.out.println("수고하셨습니다!");
		System.exit(0);

	}

	public static void main(String[] args) {
		System.out.println("::::: 성적출력 프로그램 :::::");
		while (true) {
			run();
		}
	}

}
