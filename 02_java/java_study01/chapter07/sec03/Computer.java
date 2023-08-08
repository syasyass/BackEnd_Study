package java_study01.chapter07.sec03;

public class Computer {

	private int price;
	private String maker;
	private int monitor;

	// 생성자
	public Computer() {
	}

	public Computer(int price, String maker, int monitor) {
		this.price = price;
		this.maker = maker;
		this.monitor = monitor;
	}

	// Getter, Setter
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getMonitor() {
		return monitor;
	}

	public void setMonitor(int monitor) {
		this.monitor = monitor;
	}

	// toString
	@Override
	public String toString() {
		return "Computer [price=" + price + ", maker=" + maker + ", monitor=" + monitor + "]";
	}

}
