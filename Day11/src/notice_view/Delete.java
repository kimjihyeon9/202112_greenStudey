package notice_view;

import notice.R;

public class Delete extends NoticeView {
	@Override
	public void display() {
		System.out.println("DELETE -----------------------------------------------------");
		if(R.noticeVo == null) {
			System.out.println("검색 결과 : 존재하지 않습니다.");
			return;
		}
		System.out.println(R.noticeVo);
		
		System.out.print("정말로 삭제하시겠습니까? (y/n) ");
		char yn = scan.next().charAt(0);
		if(yn == 'n') {
			R.noticeVo = null;
		}
	}
}
