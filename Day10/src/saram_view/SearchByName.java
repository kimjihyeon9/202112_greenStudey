package saram_view;

import saram.R;
import saram_model.SaramVo;

public class SearchByName extends SaramView {
	@Override
	public void display() {
		System.out.println("::::: 사람 정보 검색 :::::");
		System.out.print("검색 할 이름>> ");
		String name = scan.next();
		R.saramVo = new SaramVo(0, name, null, null);
		// controller 로 이동
	}
}
