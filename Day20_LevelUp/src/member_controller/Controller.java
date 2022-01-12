package member_controller;

import member_resource.R;
import member_view.MemberView;

public abstract class Controller extends R {
	public abstract MemberView handlerMapping();
}
