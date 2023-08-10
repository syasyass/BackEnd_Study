package java_study01.chapter09.sec08;

public class Product<T, M> {
	private T kind;
	private M model;

	public T getKind() {
		return this.kind;
	}

	public M getModel() {
		return this.model;
	}

	public void setKind(T kind) {
		this.kind = kind;
	}

	public void setModel(M model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Product [kind=" + kind + ", model=" + model + "]";
	}

}
