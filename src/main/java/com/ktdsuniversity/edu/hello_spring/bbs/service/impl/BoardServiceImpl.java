package com.ktdsuniversity.edu.hello_spring.bbs.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.service.BoardService;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.ModifyBoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;
import com.ktdsuniversity.edu.hello_spring.common.beans.FileHandler;
import com.ktdsuniversity.edu.hello_spring.common.vo.StoreResultVO;

@Service
public class BoardServiceImpl implements BoardService{
	// application.yml 파일에서 app.multipart.base-dir을 가져온다.
	//@Value는 스프링 빈에서만 사용가능
	// SpringBean: @controller @service @Repository 
	
	//@Value("${app.multipart.base-dir}")
	//private String baseDirectory;
	
	@Autowired
	private FileHandler fileHanlder;
	
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public BoardListVO getAllBoard() {
		//게시글 목록 화면에 데이터를 전송해주기 위해서 게시글의 건수와 목록을 조회해 반환시킨다.
		
		//1.게시글 건수를 조회
		
		int boardCount = this.boardDao.selectBoardAllCount();
		
		//2.  ||  목록 조회
		
		List<BoardVO> boardList = this.boardDao.selectAllBoard();
		
		//3. 건수와 목록을 할당
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardCnt(boardCount);
		boardListVO.setBoardlist(boardList);
				
		//4. BoardListVO 인스턴스를 반환
		return boardListVO;
	}

	@Override
	public boolean createNewBoard(WriteBoardVO writeBoardVO) {
		
		MultipartFile file = writeBoardVO.getFile();
		StoreResultVO storeResultVO= this.fileHanlder.storeFile(file);
		if(storeResultVO !=null) {
			writeBoardVO.setFileName(storeResultVO.getObfuscatedFileName());
			writeBoardVO.setOriginFileName(storeResultVO.getOrginalFileName());
		}
		
		
		int rowcount = boardDao.insertNewBoard(writeBoardVO);
		
		return rowcount>0;
		
	}

	@Override
	public BoardVO getOneBoard(int id, boolean isIncrease) {
		if(isIncrease) {
			int updateCount = boardDao.increaseViewCount(id);
			if (updateCount ==0 ) {
				throw new IllegalArgumentException("잘못된 접근입니다");
			}	
		}
		BoardVO boardVO = boardDao.GetOneBoard(id);
		if(boardVO==null) {
			throw new IllegalArgumentException("잘못된 접근입니다");
		}
		
		return boardVO;
	}

	@Override
	public boolean updateOneBoard(ModifyBoardVO modifyBardVO) {
		
		BoardVO boardVO =this.boardDao.GetOneBoard(modifyBardVO.getId());
		
		MultipartFile file= modifyBardVO.getFile();
		StoreResultVO storeResultVO= this.fileHanlder.storeFile(file);
		if(storeResultVO !=null) {
			modifyBardVO.setFileName(storeResultVO.getObfuscatedFileName());
			modifyBardVO.setOriginFileName(storeResultVO.getOrginalFileName());
		}
		
		
		int rowcount = boardDao.updateOneBoard(modifyBardVO);
		if(rowcount>0) {
			this.fileHanlder.deleteFile(boardVO.getFileName());;
		}
		
		return rowcount>0;
	
	}

	@Override
	public boolean deleteOneBoard(int id) {
		
		BoardVO boardVO = this.boardDao.GetOneBoard(id);
		
		int rowcount = boardDao.deleteOneBoard(id);
				
		if(rowcount>0) {
			this.fileHanlder.deleteFile(boardVO.getFileName());
		}
				
;		return rowcount > 0;
	}


	

	

}
