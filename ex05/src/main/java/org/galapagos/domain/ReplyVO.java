package org.galapagos.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
		private Long no;
		private Long cno;	//Comment의 no
		
		private String content;
		private String writer;
		private Date regDate;
		private Date updateDate;
}
