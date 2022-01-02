package notice_view;

import notice.R;
import notice_model.NoticeVo;

public class NoticeByMessage extends NoticeView{
	@Override
	public void display() {
		System.out.println("::::: 메시지 검색 :::::");
		System.out.print("메시지 입력 >> ");
		String message = scan.next();
		
		R.noticeVo = new NoticeVo(0, null, message, null);
	}
}
