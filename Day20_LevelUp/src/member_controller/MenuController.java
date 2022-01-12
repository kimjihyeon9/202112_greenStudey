package member_controller;

import member_view.MemberView;

public class MenuController extends Controller {

	@Override
	public MemberView handlerMapping() {
		// 어떤 처리를 하고 보여줄 화면을 반환.
		return menu;
	}

}
