package org.constudy21.saram.view;

import org.constudy21.model.SaramVo;
import org.constudy21.saram.R;

public class SaramEdit extends SaramView {

	@Override
	public void display() {

		while (R.type == R.SEARCH) {
			System.out.println("::::: ��� ���� ���� :::::");
			System.out.print("�����ϰ� ���� ��� �̸� �Է�>> ");
			String name = scan.next();
			R.saramVo = new SaramVo(0, name, null, null);
		}

		while (true) {
			System.out.print("������ �̸�>>");
			String name = scan.next();
			R.saramVo.setName(name);
			
			System.out.print("������ ��ȣ>>");
			String phone = scan.next();
			R.saramVo.setPhone(phone);
			
			System.out.print("������ �̸���>>");
			String email = scan.next();
			R.saramVo.setEmail(email);
			break;
		}

	}

}
