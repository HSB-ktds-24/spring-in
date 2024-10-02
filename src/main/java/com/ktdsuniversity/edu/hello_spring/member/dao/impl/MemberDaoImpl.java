package com.ktdsuniversity.edu.hello_spring.member.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberWriteVO;

@Repository
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		System.out.println("Autowiring sqlSessionTemplate: " + sqlSessionTemplate);
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int selectEmailCount(String email) {
		
		return this.getSqlSession()
				.selectOne("com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao.selectEmailCount", email);
	}

	@Override
	public int insertNewMember(MemberWriteVO memberWriteVO) {
		return getSqlSession().insert("com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao.insertNewMember", memberWriteVO);
	}

}
