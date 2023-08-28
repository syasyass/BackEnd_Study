package org.galapagos.jelly.command;

import java.util.List;

import org.galapagos.common.cli.Input;
import org.galapagos.common.cli.command.Command;
import org.galapagos.jelly.dao.TravelDao;
import org.galapagos.jelly.dao.TravelMySQLDaoImpl;
import org.galapagos.jelly.utils.TravelUtil;
import org.galapagos.jelly.vo.Region;
import org.galapagos.jelly.vo.TravelVO;

public class TravelRegionCommand implements Command {
	TravelDao dao = TravelMySQLDaoImpl.getInstance();

	@Override
	public void execute() {
		// 권역 리스트를 출력
		// 1) 수도권(13)
		// 2) 경상권(14)
		// ...
		// 6) 제주권(44)
		// 선택: 2 --> 경상권 선택
		// 경상권 목록 보기 출력

		List<Region> regions = dao.getRegions();
//		for (int i = 0; i < regions.size(); i++) {
//			Region r = regions.get(i);
//			System.out.printf("%d) %s\n", i + 1, r);
//		}
//		int sel = Input.readInt("권역 선택: ");
//		String region = regions.get(sel - 1).getRegion();

		Region region = Input.select("권역 선택: ", regions);
		List<TravelVO> list = dao.getSpots(region.getRegion());

		TravelUtil.printTravelList(list);

		System.out.printf("총 %d 건\n", list.size());

	}

}
