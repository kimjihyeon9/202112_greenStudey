package org.constudy21.saram.view;

import org.constudy21.model.SaramVo;
import org.constudy21.saram.R;

public class InsertView extends SaramView {
	@Override
	public void display() {
		System.out.println(":::::�Է� ���:::::");
		// ����, ��ȭ, �̸���
		// R.saramVo�� ���� �� controller�� �̵�
		System.out.println("���� �Է�>> ");
		String name = scan.next();

		System.out.print("��ȭ �Է�>>");
		String phone = scan.next();

		System.out.print("�̸���>>");
		String email = scan.next();

		R.saramVo = new SaramVo(0, name, phone, email);
		System.out.println("�Է� �Ϸ�!");
		// �ڵ� �Ϸ��� �ڵ����� controller�� �̵�
	}
}
