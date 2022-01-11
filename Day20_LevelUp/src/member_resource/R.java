package member_resource;

import java.util.Scanner;

import member_view.Delete;
import member_view.End;
import member_view.Input;
import member_view.List;
import member_view.MainActivity;
import member_view.MemberView;
import member_view.Modify;
import member_view.Search;

public class R {
	// title of view pages
	public static final String titleInput = "::: 입력 기능 :::";
	public static final String titleList = "::: 회원 목록 :::";
	public static final String titleSearch = "::: 검색 기능 :::";
	public static final String titleModify = "::: 수정 기능 :::";
	public static final String titleDelete = "::: 삭제 기능 :::";
	public static final String titleEnd = "::: 프로그램 종료 :::";
	public static final String titleApp = "::: 회원관리 프로그램 :::";
	
	public static final Scanner scan = new Scanner(System.in);
	
	public static final MemberView input = new Input();
	public static final MemberView list = new List();
	public static final MemberView search = new Search();
	public static final MemberView modify = new Modify();
	public static final MemberView delete = new Delete();
	public static final MemberView end = new End();
	
	public static final MainActivity mainActivity = new MainActivity();
}