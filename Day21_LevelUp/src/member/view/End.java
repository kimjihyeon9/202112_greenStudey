package member.view;

public class End extends MemberView {

	@Override
	public boolean onCreate() {
		System.out.println(titleEnd);

		System.out.println("!----- 다음에 또 만나요^^ -----!");
		System.exit(0);

		return false;
	}

}
