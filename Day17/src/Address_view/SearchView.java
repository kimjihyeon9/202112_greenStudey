package Address_view;

import Address.R;
import Address_model.AddressVo;

public class SearchView extends AddrView {
	@Override
	public void display() {
		System.out.println("-------------------------- 검색 --------------------------");
		System.out.print("검색 할 이름>> ");
		String name = getLine();
		
		R.addressvo = new AddressVo(0, name, null, null, null);
	}
}
