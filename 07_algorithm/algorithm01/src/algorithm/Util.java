package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Util {
	// �迭�� ��ҿ� ���ؼ� ī������ ���� �����ϴ� �Լ�
	// �迭�� ��� Ÿ���� ���ʸ����� ��
	// �޼����: countMap
	public static <T> Map<T, Integer> countMap(T[] arr){
	
		Map<T, Integer> map = new HashMap<T, Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			map.put(arr[i],map.getOrDefault(arr[i], 0) + 1);
		}
		
		return map;	
	}
	
	public static int[] swap(int[] array, int i, int ix){
		int temp = 0;
		temp = array[i];
		array[i] = array[ix];
		array[ix] = temp;
		return array;
	}
}
