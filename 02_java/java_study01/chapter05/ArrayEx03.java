package java_study01.chapter05;

public class ArrayEx03 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 }; // new int[] 생략
		int[] arr2 = new int[] { 5, 6, 7, 8 };

		// arr = {10,11,12}; //에러: 초기화 때만 가능, 이후로는 arr[0] = 12;

		arr = new int[] { 10, 11, 12 }; // 이렇게는 가능. 참조를 새로운 배열로 바꾸겠다는 것.

	}

}
