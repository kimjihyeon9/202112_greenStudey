package notice_view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import notice.R;
import notice_model.NoticeVo;

public class InsertView extends NoticeView {
	@Override
	public void display() {
		System.out.println("INSERT -----------------------------------------------------");
		System.out.print("이름>> ");
		String name = scan.next();
		
		System.out.print("메모 내용>> ");
		String message = scan.next();
		
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		String regDate = myDateObj.format(myFormatObj);
		System.out.println("Now time : " + regDate);
		
		R.noticeVo = new NoticeVo(0, name, message, regDate);
		System.out.println("입력 완료!");
	}
}
