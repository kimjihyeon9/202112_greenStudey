package member.view;

import member.model.MemberDTO;

public class Input extends MemberView {
	@Override
	public boolean onCreate() {
		System.out.println(titleInput);
		// 입력 받아서 R에 저장하기
		System.out.print("성명 입력 : ");
		String name = scan.next();
		System.out.print("이메일 입력 : ");
		String email = scan.next();
		System.out.print("전화번호 입력 : ");
		String phone = scan.next();
		
		request.put("inMember", new MemberDTO(0, name, email, phone));

		return false;
	}
}