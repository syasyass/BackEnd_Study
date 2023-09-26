package org.galapagos.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class CommentVO {
	private Long no;
	private Long bno;
	
	private String content;
	private String writer;
	private Date regDate;
	private Date updateDate;
	
	List<ReplyVO> replyList;
}
