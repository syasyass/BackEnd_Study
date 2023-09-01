package org.galapagos.travel.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelVO {
	private int no;
	private String region;
	private String title;
	private String address;
	private String phone;
	private String description;
}
