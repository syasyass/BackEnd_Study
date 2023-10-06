package algorithm01.sec04;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackEx01 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println(stack.empty() ? 1 : 0);
		
		try {
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
		} catch(EmptyStackException e) {
			System.out.println("-1");
		}
		System.out.println(stack.size());
		System.out.println(stack.empty() ? 1 : 0);
		
		try {
			System.out.println(stack.pop());
		} catch(EmptyStackException e) {
			System.out.println("-1");
		}
		stack.push(3);
		System.out.println(stack.empty() ? 1 : 0);
		System.out.println(stack.peek());

	}

}
