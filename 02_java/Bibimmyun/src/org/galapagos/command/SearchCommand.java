package org.galapagos.command;

public class SearchCommand implements Command {

	@Override
	public void execute() {
		System.out.println("검색을 실행합니다.");
	}

}
