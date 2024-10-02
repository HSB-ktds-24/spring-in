package com.ktdsuniversity.edu.hello_spring.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao;
import com.ktdsuniversity.edu.hello_spring.member.service.MemberService;

import com.ktdsuniversity.edu.hello_spring.member.vo.MemberWriteVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public boolean createNewMember(MemberWriteVO memberWriteVO) {
		int result = memberDao.insertNewMember(memberWriteVO);
		return result >0;
	}

	@Override
	public boolean checkAvailableEamil(String email) {
		return this.memberDao.selectEmailCount(email)==0;
	}

}
