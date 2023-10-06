package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Util {
	// 배열의 요소에 대해서 카운팅한 맵을 리턴하는 함수
	// 배열의 요소 타입은 제너릭으로 함
	// 메서드명: countMap
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
