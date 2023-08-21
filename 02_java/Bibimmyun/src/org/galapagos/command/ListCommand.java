package org.galapagos.command;

public class ListCommand implements Command {

	@Override
	public void execute() {
		System.out.println("목록을 출력합니다.");
	}

}
