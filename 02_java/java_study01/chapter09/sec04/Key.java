package java_study01.chapter09.sec04;

public class Key {
	public int number;

	public Key(int number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Key) {
			Key compareKey = (Key) obj;
			if (this.number == compareKey.number) {
				return true;
			}
		}
		return false;
	}

	// 디폴트 해시코드는 해당 객체의 주소를 사용하기 때문에 number를 사용하겠다고 오버라이드
	@Override
	public int hashCode() {
		return number;
	}
}