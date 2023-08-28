package org.galapagos.jelly.command;

import java.util.List;

import org.galapagos.common.cli.Input;
import org.galapagos.common.cli.command.Command;
import org.galapagos.jelly.dao.TravelDao;
import org.galapagos.jelly.dao.TravelMySQLDaoImpl;
import org.galapagos.jelly.utils.TravelUtil;
import org.galapagos.jelly.vo.TravelVO;

public class TravelSearchCommand implements Command {
	TravelDao dao = TravelMySQLDaoImpl.getInstance();

	@Override
	public void execute() {
		// 검색어:
		// 검색 결과 출력

		String keyword = Input.read("검색어: ");

		// Dao로 검색
		List<TravelVO> list = dao.search("%" + keyword + "%");

		// 검색 결과 출력
		TravelUtil.printTravelList(list);
		System.out.printf("총 %d건\n", list.size());
	}
}
