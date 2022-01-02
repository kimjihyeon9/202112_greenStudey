package saram_view;

import saram.R;
import saram_model.SaramVo;

public class InsertView extends SaramView {
	@Override
	public void display() {
		System.out.println("::::: 입력 기능 :::::");
		// 성명, 정화, 이메일
		// R.saramVo 에 저장 후 Controller 로 이동
		System.out.print("성명 입력>> ");
		String name = scan.next();
		System.out.print("전화 입력>> ");
		String phone = scan.next();
		System.out.print("이메일>> ");
		String email = scan.next();
		
		R.saramVo = new SaramVo(0, name, phone, email);
		System.out.println("입력 완료!");
		// 작업
	}
}
