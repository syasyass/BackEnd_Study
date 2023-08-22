package org.galapagos.bibimmyun.command;

import org.galapagos.common.cli.command.Command;

public class ExitCommand implements Command {

	@Override
	public void execute() {
		System.out.println("종료합니다.");
		System.exit(0);
	}

}
