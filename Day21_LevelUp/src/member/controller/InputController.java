package member.controller;

import member.model.MemberDTO;
import member.view.MemberView;

public class InputController extends Controller{

	@Override
	public MemberView hadleRequest() {
		MemberDTO dto = (MemberDTO)request.get("inMember");
		memDao.insert(dto);
		
		// 어떤 처리를 하고 보여줄 화면을 반환
		return input; 
	}
	
}
