package com.ktdsuniversity.edu.hello_spring.bbs.dao;

import java.util.List;

import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.ModifyBoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;

public interface BoardDao {
	
	public int selectBoardAllCount();
	public List<BoardVO> selectAllBoard();
	public int insertNewBoard(WriteBoardVO writeBoardVO); //row 의 개수
	// 이하 추가 작성
	public int increaseViewCount(int id);
	
	public BoardVO GetOneBoard(int id);
	
	public int updateOneBoard(ModifyBoardVO modifyBoardVO);
	
	public int deleteOneBoard(int id);
}
