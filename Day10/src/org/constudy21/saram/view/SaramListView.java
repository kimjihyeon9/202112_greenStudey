package org.constudy21.saram.view;

import org.constudy21.model.SaramVo;
import org.constudy21.saram.R;

public class SaramListView extends SaramView {
	public void display() {
		System.out.println(":::::������:::::");
		//R.saramArr ���
		for(SaramVo saram : R.saramArr) {
			System.out.println(saram);
		}
	}
}
