package org.galapagos.jelly.command;

import org.galapagos.common.cli.Input;
import org.galapagos.common.cli.command.Command;
import org.galapagos.jelly.dao.TravelDao;
import org.galapagos.jelly.dao.TravelMySQLDaoImpl;
import org.galapagos.jelly.vo.TravelVO;

public class TravelDetailCommand implements Command {
	TravelDao dao = TravelMySQLDaoImpl.getInstance();

	@Override
	public void execute() {
		// No: 104
		System.out.println("조회를 원하는 번호를 입력하세요.");

		int no = Input.readInt("관광지 번호: ");
		TravelVO travel = dao.findById(no);

		// 권역: xxxx
		// 관광지명: xxxxx
		// 주소: xxxx
		// 전화번호: xxxx
		// xxxxxxxxxxxxxx ....
		if (travel == null) {
			System.out.println("잘못된 번호입니다.");
			return;
		} else {
			System.out.println("================================================");
			System.out.println("권	역: " + travel.getRegion());
			System.out.println("관광지명: " + travel.getTitle());
			System.out.println("주	소: " + travel.getAddress());
			System.out.println("전화번호: " + travel.getPhone());
			System.out.println();
			System.out.println(travel.getDescription().replace(". ", ".\n"));
		}
		System.out.println("================================================");
	}

}
