package com.ktdsuniversity.edu.hello_spring.member.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktdsuniversity.edu.hello_spring.member.service.MemberService;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberWriteVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/regist")
	public String viewRegistMemberPage() {
		return "member/memberregist";
	}
	
	@PostMapping("/member/regist")
	public String doCreateNewMember(MemberWriteVO memberWriteVO, Model model){
		
		boolean isCreated = this.memberService.createNewMember(memberWriteVO);
		String result = isCreated?"회원이 등록되었습니다.":"회원 등록에 실패하였습니다.";
		System.out.println(result);
		model.addAttribute(memberWriteVO);
		return "redirect:/member/regist";
	}
	
	@ResponseBody
	@GetMapping("/member/regist/available")
	public Map<String, Object> doCheckAvailableEmail(@RequestParam String email){
		boolean isAvailableEmail = this.memberService.checkAvailableEamil(email);
		
		Map<String,Object> response = new HashMap<String, Object>();
		response.put("email",email);
		response.put("available",isAvailableEmail);
		return response;
	}

}
