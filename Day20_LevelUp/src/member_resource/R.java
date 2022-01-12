package member_resource;

import java.awt.Menu;
import java.util.Hashtable;
import java.util.Scanner;

import member_controller.Controller;
import member_controller.DeleteController;
import member_controller.EndController;
import member_controller.InputController;
import member_controller.ListController;
import member_controller.MenuController;
import member_controller.ModifyController;
import member_controller.SearchController;
import member_model.MemberDAO;
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
	public static final String titleMenu = "::: 회원관리 프로그램 :::";
	
	public static final Scanner scan = new Scanner(System.in);
	
	public static final MemberView input = new Input();
	public static final MemberView list = new List();
	public static final MemberView search = new Search();
	public static final MemberView modify = new Modify();
	public static final MemberView delete = new Delete();
	public static final MemberView end = new End();
	public static final MemberView menu = new Menu();
	
	public static final MainActivity mainActivity = new MainActivity();
	
	public static final MemberDAO memDao = new MemberDAO();
	
	public static final Hashtable<Integer, Controller> ctrlMapper = new Hashtable<Integer, Controller>();
	public static final int MENU=0, INPUT=1, LIST=2, SEARCH=3, MODIFY=4, DELETE=5, END=6;
	static {
		ctrlMapper.put(MENU, new MenuController());
		ctrlMapper.put(INPUT, new InputController());
		ctrlMapper.put(LIST, new ListController());
		ctrlMapper.put(SEARCH, new SearchController());
		ctrlMapper.put(MODIFY, new ModifyController());
		ctrlMapper.put(DELETE, new DeleteController());
		ctrlMapper.put(END, new EndController());
	}
}
