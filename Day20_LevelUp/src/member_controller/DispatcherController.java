package member_controller;

import member_resource.R;
import member_view.MemberView;

public class DispatcherController extends R {
	private static MemberView view = null;
	
	public static void run() {
		view = new InputController().handlerMapping();
		
		mainActivity.setContentView(view);
	}
}
