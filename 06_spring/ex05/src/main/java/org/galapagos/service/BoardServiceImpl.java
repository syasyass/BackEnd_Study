package org.galapagos.service;

import java.util.List;

import org.galapagos.domain.BoardAttachmentVO;
import org.galapagos.domain.BoardVO;
import org.galapagos.domain.Criteria;
import org.galapagos.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor //생성자를 통해 와이어링 할 수 있다는 것을 설명하기 위해 작성 (@Autowired를 대신하는 역할)
public class BoardServiceImpl implements BoardService {

//	@Autowired
	private BoardMapper mapper;
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void register(BoardVO board, List<MultipartFile> files)  throws Exception {
		mapper.insertSelectKey(board);
		Long bno = board.getBno();
		
		for(MultipartFile part: files) {
			if(part.isEmpty()) continue;
				BoardAttachmentVO attach = new BoardAttachmentVO(bno, part);
				mapper.insertAttachment(attach);
		}
	}

	@Override
	public BoardVO get(Long bno) {		
		BoardVO board = mapper.read(bno);
		
		List<BoardAttachmentVO> list = mapper.getAttachmentList(bno);
		board.setAttaches(list);
		
		return board;
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modiify......." + board);
		
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove......." + bno);
		
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("get List with criteria: " + cri);
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}
	
	@Override
	public BoardAttachmentVO getAttachment(Long no) {
		return mapper.getAttachment(no);
	}
	
	@Override
	public boolean removeAttachment(Long no) {
		return mapper.removeAttachment(no) == 1;
	}

}
