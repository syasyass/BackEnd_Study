package org.galapagos.jelly.vo;

class TravelVOTest {

	public static void main(String[] args) {
		// TravelVO travel = new TravelVO(...);
		// Builder 패턴
		TravelVO travel = TravelVO.builder().address("서울 특별시") // 메서드 체인닝
				.region("수도권").title("멀티캠퍼스").phone("010-111-2222").build();

		System.out.println(travel);

	}
}
