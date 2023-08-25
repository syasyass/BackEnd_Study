package org.galapagos.jelly.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelVO {
	private int no;
	private String region;
	private String title;
	private String description;
	private String address;
	private String phone;

}
