package org.galapagos.command;

public class ExitCommand implements Command {

	@Override
	public void execute() {
		System.out.println("종료합니다.");
		System.exit(0);
	}

}
