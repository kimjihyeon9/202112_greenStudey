package member_view;

import member_resource.R;

public abstract class MemberView extends R {
	public void display() {
		onCreate();
	}

	public abstract void onCreate();
}
