package notice_model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NoticeDao {
	public static final int MAX = 100;
	private static final NoticeVo[] noticeArr = new NoticeVo[MAX];
	private static int top = 0;
	private static int noticeSeq = 1;

	public static String regDate() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		return formattedDate;
	}

	static {
		noticeArr[top++] = new NoticeVo(noticeSeq++, "KIM", "안녕", regDate());
		noticeArr[top++] = new NoticeVo(noticeSeq++, "LEE", "Hello", regDate());
		noticeArr[top++] = new NoticeVo(noticeSeq++, "PARK", "Hi~", regDate());
	}

	// selectAll(전체출력), selectOne(이름으로 검색), selectByNo(숫자로 검색),
	// update(수정), delete(삭제), insert(입력) 구현

	public NoticeVo[] selectAll() { // 전체출력
		NoticeVo[] newNArr = new NoticeVo[top];
		for (int i = 0; i < newNArr.length; i++) {
			NoticeVo newNotice = new NoticeVo();
			newNotice.setNo(noticeArr[i].getNo());
			newNotice.setUser(noticeArr[i].getUser());
			newNotice.setMessage(noticeArr[i].getMessage());
			newNotice.setRegDate(noticeArr[i].getRegDate());
			newNArr[i] = newNotice;
		}

		return newNArr;
	}

	public NoticeVo selectOne(NoticeVo vo) { // 이름으로 검색
		for (int i = 0; i < top; i++) {
			if (vo.getUser().equals(noticeArr[i].getUser())) {
				NoticeVo newNotice = new NoticeVo();
				newNotice.setNo(noticeArr[i].getNo());
				newNotice.setUser(noticeArr[i].getUser());
				newNotice.setMessage(noticeArr[i].getMessage());
				newNotice.setRegDate(noticeArr[i].getRegDate());
				return newNotice;
			}
		}
		return null;
	}

	public NoticeVo selectByNo(int n) { // 번호로 검색
		for (int i = 0; i < top; i++) {
			if (n == noticeArr[i].getNo()) {
				NoticeVo newNotice = new NoticeVo();
				newNotice.setNo(noticeArr[i].getNo());
				newNotice.setUser(noticeArr[i].getUser());
				newNotice.setMessage(noticeArr[i].getMessage());
				newNotice.setRegDate(noticeArr[i].getRegDate());
				return newNotice;
			}
		}
		return null;
	}

	public NoticeVo selectMessage(NoticeVo vo) {
		for (int i = 0; i < top; i++) {
			if (noticeArr[i].getMessage().indexOf(vo.getMessage()) != -1) { // 비교할대상.indexof(비교할 값)
				NoticeVo newNotice = new NoticeVo();
				newNotice.setNo(noticeArr[i].getNo());
				newNotice.setUser(noticeArr[i].getUser());
				newNotice.setMessage(noticeArr[i].getMessage());
				newNotice.setRegDate(noticeArr[i].getRegDate());
				return newNotice;
			}
		}
		return null;
	}

	public void insert(NoticeVo vo) { // 추가
		if (top > MAX - 1) {
			System.out.println("더이상 추가할 수 없습니다.");
			return;
		}
		vo.setNo(noticeSeq++);
		noticeArr[top++] = vo;
	}

	public void update(NoticeVo vo) { // 수정
		if (vo == null)
			return;
		for (int i = 0; i < top; i++) {
			if (noticeArr[i].getNo() == vo.getNo()) {
				noticeArr[i] = vo;
				noticeArr[i].setRegDate(regDate());
			}
		}
	}

	public void delete(NoticeVo vo) { // 삭제
		for (int i = 0; i < top; i++) {
			if (noticeArr[i].getNo() == vo.getNo()) {
				for (int j = i; j < top - 1; j++) {
					noticeArr[j] = noticeArr[j + 1];
				}
				noticeArr[top - 1] = null;
				top--;
			}
		}
	}
}
