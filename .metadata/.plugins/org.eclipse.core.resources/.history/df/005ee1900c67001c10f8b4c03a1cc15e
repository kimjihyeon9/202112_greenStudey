package org.constudy21.saram.view;

import org.constudy21.model.SaramVo;
import org.constudy21.saram.R;

public class SaramEdit extends SaramView {

	@Override
	public void display() {

		while (R.type == R.SEARCH) {
			System.out.println("::::: 사람 정보 수정 :::::");
			System.out.print("수정하고 싶은 사람 이름 입력>> ");
			String name = scan.next();
			R.saramVo = new SaramVo(0, name, null, null);
		}

		while (true) {
			System.out.print("수정할 이름>>");
			String name = scan.next();
			R.saramVo.setName(name);
			
			System.out.print("수정할 번호>>");
			String phone = scan.next();
			R.saramVo.setPhone(phone);
			
			System.out.print("수정할 이메일>>");
			String email = scan.next();
			R.saramVo.setEmail(email);
			break;
		}

	}

}
