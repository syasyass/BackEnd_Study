package org.galapagos.mcmorning.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	private String userid;
	private String password;
	private String name;
	private String email;
}