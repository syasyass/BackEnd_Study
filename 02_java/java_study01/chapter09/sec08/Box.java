package java_study01.chapter09.sec08;

public class Box<T> {

	private T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
}