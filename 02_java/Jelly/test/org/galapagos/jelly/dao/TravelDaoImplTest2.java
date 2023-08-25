package org.galapagos.jelly.dao;

import org.galapagos.jelly.vo.TravelVO;

class TravelDaoImplTest2 {

	public static void main(String[] args) {
		TravelDao dao = TravelDaoImpl.getInstance();

		TravelVO travel = dao.findById(10);
		System.out.println(travel);
	}
}
