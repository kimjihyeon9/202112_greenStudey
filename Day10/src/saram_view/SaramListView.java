package saram_view;

import saram.R;
import saram_model.SaramVo;

public class SaramListView extends SaramView {
	@Override
	public void display() {
		System.out.println("::::: 사람 목록 :::::");
		// R.saramArr 출력
		for(SaramVo saram : R.saramArr) {
			System.out.println(saram);
		}
	}
}
