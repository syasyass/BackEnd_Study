package algorithm01.sec02;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapEx01 {

	public static void main(String[] args) {
		Map member = new LinkedHashMap();
		
		member.put("100", "김데이");
		member.put("200", "김사전");
		member.put("300", "김구조");
		member.put("400", "김자료");
		System.out.println(member);
		
		member.remove("200");
		member.put("300", "김충성");
		System.out.println(member);
		
		for(Object key: member.keySet()) { //위에서 map에 제네릭을 안 줬기 때문에 타입이 Object
			System.out.println(key + "=" + member.get(key));
		}
	}

}
