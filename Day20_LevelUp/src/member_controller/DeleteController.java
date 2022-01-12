package member_controller;

import member_view.MemberView;

public class DeleteController extends Controller {

	@Override
	public MemberView handlerMapping() {
		return delete;
	}

}
