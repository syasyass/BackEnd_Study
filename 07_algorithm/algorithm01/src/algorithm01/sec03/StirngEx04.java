package algorithm01.sec03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StirngEx04 {

	public static void main(String[] args) {
		String[] all = {"홍길동", "김길동", "정길동", "홍길동", "김길동", "홍길동"};
		String[] find = {"홍길동", "김길동", "정길동"};
		String answer = "";
		
		//key : value 형태로 저장
		HashMap<String, Integer> map = new HashMap<>();
		
		//모든 참가자 명단을 map에 넣자.
		for(String player : find ) {
			map.put(player, 0);
		}
		//map.getOrDefault(player, 0)
		System.out.println(map);
		
		//투표자 명단에서 한 명씩 꺼내어 map에 1을 더하자.
		for(String player : all) {
			map.put(player, map.get(player) + 1);
		}
		System.out.println(map);
		
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		
		Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
		
		for(Map.Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		int max = 0;
		for(String x : map.keySet()) {
			if(map.get(x) > max) {
				max = map.get(x);
				answer = x;
			}
		}
		
		System.out.println("우승자: " + answer);
	}

}
