package org.hotdog.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	@Select("SELECT sysdate()")
	public String getTime();
	
	public String getTime2();
}
