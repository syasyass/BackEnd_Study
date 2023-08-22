package org.galapagos.bibimmyun.command;

import org.galapagos.common.cli.command.Command;

public class ListCommand implements Command {

	@Override
	public void execute() {
		System.out.println("목록을 출력합니다.");
	}

}
