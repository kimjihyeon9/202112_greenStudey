package org.constudy21.saram.view;

import org.constudy21.model.SaramVo;
import org.constudy21.saram.R;

public class SaramDetail extends SaramView {
	@Override
	public void display() {
		if (R.type == R.SEARCH) {
			System.out.println("::::: ��� ���� �˻� :::::");
			System.out.print("�˻� �� �̸�>> ");
			String name = scan.next();
			R.saramVo = new SaramVo(0, name, null, null);
			// controller�� �̵�
		} else {
			System.out.println("::::: ��� ���� �󼼺��� :::::");
			System.out.println(R.saramVo);
		}
	}
}
