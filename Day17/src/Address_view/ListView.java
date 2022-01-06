package Address_view;

import java.util.Iterator;

import Address.R;
import Address_model.AddressVo;

public class ListView extends AddrView {
	@Override
	public void display() {
		System.out.println("-------------------------- 조회 --------------------------");
		
		Iterator<AddressVo> it = R.addressList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
