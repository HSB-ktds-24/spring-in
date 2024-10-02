package com.ktdsuniversity.edu.hello_spring.member.dao;


import com.ktdsuniversity.edu.hello_spring.member.vo.MemberWriteVO;

public interface MemberDao {

	public int selectEmailCount(String email);
	public int insertNewMember(MemberWriteVO memberWriteVO);
}
