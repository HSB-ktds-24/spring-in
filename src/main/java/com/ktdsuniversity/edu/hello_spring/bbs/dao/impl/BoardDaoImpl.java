package com.ktdsuniversity.edu.hello_spring.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.ModifyBoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		System.out.println("Autowiring sqlSessionTemplate: " + sqlSessionTemplate);
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int selectBoardAllCount() {
		return this.getSqlSession()
				.selectOne("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.selectBoardAllCount");
	}

	@Override
	public List<BoardVO> selectAllBoard() {
	
		return this.getSqlSession()
				.selectList("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.selectAllBoard");
	}

	@Override
	public int insertNewBoard(WriteBoardVO writeBoardVO) {
		
		return this.getSqlSession().insert("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.insertNewBoard", writeBoardVO);
	}
	
	
	//w

	@Override
	public int increaseViewCount(int id) {
		return getSqlSession()
				.update("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.increaseViewCount", id);
	}

	@Override
	public BoardVO GetOneBoard(int id) {
		return getSqlSession()
				.selectOne("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.getOneBoard", id);
	}

	@Override
	public int updateOneBoard(ModifyBoardVO modifyBoardVO) {
		return getSqlSession().update("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.updateOneBoard",modifyBoardVO);
		
	}

	@Override
	public int deleteOneBoard(int id) {
		
		return getSqlSession().delete("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.deleteOneBoard",id);
	}

	
}
