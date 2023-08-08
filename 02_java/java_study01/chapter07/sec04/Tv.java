package java_study01.chapter07.sec04;

public class Tv {
	int channel;
	int volume;
	boolean onOff;
	private final int SERIAL;
	// static final double PI = 3.14; //찐 상수
	static int count = 0;

	static String company = "Samsung";
	static String model = "LCD";
	static String info;

	static {
		info = company + "-" + model;
	}

	// 생성자
	public Tv() {
		count++;
		SERIAL = count;
	}

	public Tv(int channel, int volume, boolean onOff) {
		count++;
		SERIAL = count;
		this.channel = channel;
		this.volume = volume;
		this.onOff = onOff;
	}

	// getter, setter
	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public boolean isOnOff() {
		return onOff;
	}

	public void setOnOff(boolean onOff) {
		this.onOff = onOff;
	}

	public int getSerial() {
		return SERIAL;
	}

//	public void setSerial(int serial) {
//		this.SERIAL = serial;
//	}

	// toString
	@Override
	public String toString() {
		return "Tv [channel=" + channel + ", volume=" + volume + ", onOff=" + onOff + "]";
	}

}
