package com.ktdsuniversity.edu.hello_spring.bbs.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.dao.impl.BoardDaoImpl;
import com.ktdsuniversity.edu.hello_spring.bbs.service.BoardService;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;

@SpringBootTest
//제이 유닛을 사용하기 위한설정
//@ExtendWith(SpringExtension.class)

//테스트 하고자 하는 클래스와 필요한 클래스들을 임포드
@Import( {BoardServiceImpl.class, BoardDaoImpl.class})
public class BoardServiceImplTest {

	@Autowired
	private BoardService boardService;
	
	/*
	 * junit5 테스트를 위해 boardServiceImpl에 가짜 인스턴스를 DI
	 */
	
	@MockBean
	private BoardDao boardDao;
	
//	@Test
//	public void testGetAllBoard() {
//		
//		//1. boardDao.selectBoardAllCount() 가 반환시킬 값을 명시 
//		BDDMockito.given(boardDao.selectBoardAllCount()).willReturn(3);
//		
//		//2.boardDao.selectAllBoard() 반환시킬 값을 명시
//		List<BoardVO> mockList = new ArrayList<>();
//		mockList.add(new BoardVO());
//		mockList.add(new BoardVO());
//		mockList.add(new BoardVO());
//		
//		BDDMockito.given(boardDao.selectAllBoard()).willReturn(mockList);
//	
//		//3. getAllBoard를 호출 when
//		BoardListVO boardListVO = boardService.getAllBoard();
//		
//		//4. given 데이터와 실행데이터가 일치하는지 검사 than
//		assertEquals(3, boardListVO.getBoardCnt());
//		assertEquals(3, boardListVO.getBoardlist().size());
//	}
	
	@Test
	public void testcreateNewBoard() {
		//임의의 writeBoardVO
		WriteBoardVO writeBoardVO = new WriteBoardVO();
		
		//willReturn >> 리턴 데이터의 갯수
		BDDMockito.given(boardDao.insertNewBoard(writeBoardVO)).willReturn(1);
		
		// 리턴 값을 가져옴
		boolean test = boardService.createNewBoard(writeBoardVO);
		
		// 리턴값과 결과 예상값을 비교
		assertEquals(true,test);
	}

}
