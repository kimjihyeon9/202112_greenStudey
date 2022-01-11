package member_test;

import member_resource.R;

public class TestAppMain extends R {
	
	public TestAppMain() {
		viewTest();
	}

	private void viewTest() {
		mainActivity.setContentView(list);
	}

	public static void main(String[] args) {
		new TestAppMain();
	}

}
