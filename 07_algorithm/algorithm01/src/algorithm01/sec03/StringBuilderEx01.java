package algorithm01.sec03;


public class StringBuilderEx01 {

	public static void main(String[] args) {
		String s = "pongpong";
		String s2 = "pongpong";
		System.out.println(s == s2);
		
		s2 = "hahahaha";
		System.out.println(s == s2);
		
		StringBuilder sb = new StringBuilder("honghong");
		StringBuilder sb2 = new StringBuilder("honghong");
		System.out.println(sb == sb2);
		sb.append("hahaha");
		System.out.println(sb);
		sb2.replace(0, 8, "hahaha");
		System.out.println(sb2);
		sb.delete(0, 4);
		System.out.println(sb);
		sb.deleteCharAt(4);
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		
		//앞뒤로 바꿀 때 편하다.
		StringBuilder sb3 = new StringBuilder(s);
		sb3.reverse();
		System.out.println(sb3);
	}

}
