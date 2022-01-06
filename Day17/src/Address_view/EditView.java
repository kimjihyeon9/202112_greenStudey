package Address_view;

import Address.R;

public class EditView extends AddrView {
	@Override
	public void display() {
		System.out.println("-------------------------- 수정 --------------------------");
		
		if(R.addressvo == null) {
			System.out.println("검색 결과 없습니다!");
			return;
		}
		System.out.println(R.addressvo);
		
		System.out.print("이름을 수정 하시겠습니까? [y / n] ");
		char yn = scan.next().charAt(0);
		if(yn == 'Y' || yn == 'y') {
			System.out.print("새 이름>> ");
			R.addressvo.setName(getLine());
		}
		System.out.print("연락처를 수정 하시겠습니까? [y / n] ");
		yn = scan.next().charAt(0);
		if(yn == 'Y' || yn == 'y') {
			System.out.print("새 연락처>> ");
			R.addressvo.setPhone(getLine());
		}
		System.out.print("주소를 수정 하시겠습니까? [y / n] ");
		yn = scan.next().charAt(0);
		if(yn == 'Y' || yn == 'y') {
			System.out.print("새 주소>> ");
			R.addressvo.setAddr(getLine());
		}
		System.out.print("이메일을 수정 하시겠습니까? [y / n] ");
		yn = scan.next().charAt(0);
		if(yn == 'Y' || yn == 'y') {
			System.out.print("새 이메일>> ");
			R.addressvo.setEmail(getLine());
		}
		System.out.println("수정되었습니다.");
	}
}
