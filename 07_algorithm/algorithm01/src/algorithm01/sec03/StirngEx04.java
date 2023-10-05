package algorithm01.sec03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StirngEx04 {

	public static void main(String[] args) {
		String[] all = {"ȫ�浿", "��浿", "���浿", "ȫ�浿", "��浿", "ȫ�浿"};
		String[] find = {"ȫ�浿", "��浿", "���浿"};
		String answer = "";
		
		//key : value ���·� ����
		HashMap<String, Integer> map = new HashMap<>();
		
		//��� ������ ����� map�� ����.
		for(String player : find ) {
			map.put(player, 0);
		}
		//map.getOrDefault(player, 0)
		System.out.println(map);
		
		//��ǥ�� ��ܿ��� �� �� ������ map�� 1�� ������.
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
		
		System.out.println("�����: " + answer);
	}

}
