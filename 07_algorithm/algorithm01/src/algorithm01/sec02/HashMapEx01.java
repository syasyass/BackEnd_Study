package algorithm01.sec02;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapEx01 {

	public static void main(String[] args) {
		Map member = new LinkedHashMap();
		
		member.put("100", "�赥��");
		member.put("200", "�����");
		member.put("300", "�豸��");
		member.put("400", "���ڷ�");
		System.out.println(member);
		
		member.remove("200");
		member.put("300", "���漺");
		System.out.println(member);
		
		for(Object key: member.keySet()) { //������ map�� ���׸��� �� ��� ������ Ÿ���� Object
			System.out.println(key + "=" + member.get(key));
		}
	}

}
