package org.galapagos.mcmorning.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member implements Serializable {
	private String userid;
	private String password;
	private String name;
	private String email;
}