package org.galapagos.jelly.command;

import java.util.List;

import org.galapagos.common.cli.Input;
import org.galapagos.common.cli.command.Command;
import org.galapagos.jelly.dao.TravelDao;
import org.galapagos.jelly.dao.TravelMySQLDaoImpl;
import org.galapagos.jelly.utils.TravelUtil;
import org.galapagos.jelly.vo.PageRequest;
import org.galapagos.jelly.vo.TravelVO;

public class TravelListCommand implements Command {
	final static int COUNT_PER_PAGE = 10;
	TravelDao dao = TravelMySQLDaoImpl.getInstance();

	@Override
	public void execute() {
		while (true) {
			// 페이지 선택[1~12]: 3
			int totalCount = dao.getTotalCount();
			// (double) 형변환 안 했다고 에러가 나지는 않기 때문에, 신경을 써줘야 함
			int totalPage = (int) Math.ceil(totalCount / (double) COUNT_PER_PAGE);

			String title = String.format("페이지 선택[1~%d](종료: 0) ", totalPage);
			int page = Input.readInt(title);
			if (page == 0) {
				return;
			}

			// page 1: 1 ~ 10
			// page 2: 11 ~ 20
			// page 3: 21 ~ 30

			// 오라클
//			int start = (page - 1) * COUNT_PER_PAGE + 1;
//			int end = start + COUNT_PER_PAGE - 1;

			// MySQL
			int start = (page - 1) * COUNT_PER_PAGE;

			PageRequest pageRequest = new PageRequest(start, COUNT_PER_PAGE);
			List<TravelVO> list = dao.getPage(pageRequest);

			TravelUtil.printTravelList(list);

			// 총 XXX 건(현재 페이지 번호 / 총 페이지수)
			System.out.printf("총 %d 건 (페이지: %d/%d)\n", totalCount, page, totalPage);
		}
	}
}
