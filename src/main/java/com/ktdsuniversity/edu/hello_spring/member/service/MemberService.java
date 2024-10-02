package com.ktdsuniversity.edu.hello_spring.member.service;

import com.ktdsuniversity.edu.hello_spring.member.vo.MemberWriteVO;

public interface MemberService {

	public boolean createNewMember(MemberWriteVO memberWriteVO);
	
	public boolean checkAvailableEamil(String email);
	
}
