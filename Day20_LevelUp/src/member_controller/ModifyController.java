package member_controller;

import member_view.MemberView;

public class ModifyController extends Controller {

	@Override
	public MemberView handlerMapping() {
		return modify;
	}

}
