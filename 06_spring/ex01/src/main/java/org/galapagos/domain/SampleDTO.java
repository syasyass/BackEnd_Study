package org.galapagos.domain;

import lombok.Data;

@Data
public class SampleDTO {
	private String name;
	private int age;
	private int page;
	
//	(JSP/Servlet의 경우)
//	String name = request.getParameter("name");
//	int age=Integer.parseInt("age");
//	SampleDTO sampleDto = new SampleDTO();
}