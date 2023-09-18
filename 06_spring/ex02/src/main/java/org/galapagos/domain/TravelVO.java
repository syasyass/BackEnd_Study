package org.galapagos.domain;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TravelVO {
	private Long no;
	
	@NotBlank(message="권역은 필수 항목입니다.")
	private String region;
	
	@NotBlank(message="제목은 필수 항목입니다.")
	private String title;
	
	@NotBlank(message="내용은 필수 항목입니다.")
	private String description;
	
	private String address;
	private String phone;
	
}
