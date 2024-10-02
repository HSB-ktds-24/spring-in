package com.ktdsuniversity.edu.hello_spring.bbs.vo;

import java.util.List;

public class BoardListVO {
	
	private int boardCnt;
	private List<BoardVO> boardlist;
	
	public int getBoardCnt() {
		return boardCnt;
	}
	
	public void setBoardCnt(int boardCnt) {
		this.boardCnt = boardCnt;
	}
	
	public List<BoardVO> getBoardlist() {
		return boardlist;
	}
	
	public void setBoardlist(List<BoardVO> boardlist) {
		this.boardlist = boardlist;
	}
	
}
