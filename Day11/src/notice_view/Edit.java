package notice_view;

import notice.R;

public class Edit extends NoticeView {
	@Override
	public void display() {
		System.out.println("EDIT -------------------------------------------------------");
		if (R.noticeVo == null) {
			System.out.println("검색 결과 : 존재하지 않습니다.");
			return;
		}
		System.out.println(R.noticeVo);

		System.out.println("수정할 항목을 선택해주세요.");
		System.out.println("1.이름 2.메모내용 3.모두");
		System.out.print("선택>> ");
		int n = scan.nextInt();

		while (true) {
			if (n > 3 || n < 1) {
				System.out.println("범위에 없는 숫자 입니다.");
				System.out.println("수정할 항목을 선택해주세요.");
				System.out.println("1.이름 2.메모내용 3.모두");
				System.out.print("선택>> ");
				n = scan.nextInt();
			}
			break;
		}

		switch (n) {
		case 1:
			System.out.print("수정할 이름>> ");
			R.noticeVo.setUser(scan.next());
			break;
		case 2:
			System.out.print("수정할 메모내용>> ");
			R.noticeVo.setMessage(scan.next());
			break;
		case 3:
			System.out.print("수정할 이름>> ");
			R.noticeVo.setUser(scan.next());
			System.out.print("수정할 메모내용>> ");
			R.noticeVo.setMessage(scan.next());
			break;
		default:
			System.out.println("항목에 없습니다!");
			break;
		}
	}
}
