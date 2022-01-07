package Address_view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Address.R;
import Address_model.AddressVo;

public class AddView extends AddrView {
	
	@Override
	public void display() {
		System.out.println("-------------------------- 등록 --------------------------");
		
		System.out.print("이름 입력 : ");
		String name = getLine();
		
		System.out.print("전화번호 입력 : ");
		String phone = getLine();
		
		System.out.print("주소 입력 : ");
		String addr = getLine();
		
		System.out.print("이메일 입력 : ");
		String email = getLine();
		
		R.addressvo = new AddressVo(0, name, phone, addr, email);
		
		
		
		System.out.println("입력완료!");
	}
}
	


