package org.galapagos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.galapagos.domain.BoardVO;

public interface BoardMapper {
	
//	@Select("select * from tbl_board")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board); // insert 후에 bno를 모름
	
	public void insertSelectKey(BoardVO board); // insert 후에 bno를 추출
	
	public BoardVO read(Long bno); // PK 전달

	public int delete(Long bno); // PK 전달
	
	public int update(BoardVO board);
}
