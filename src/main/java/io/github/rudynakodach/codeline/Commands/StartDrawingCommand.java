package io.github.rudynakodach.codeline.Commands;

import io.github.rudynakodach.codeline.Utils.Commands.Command;

public class StartDrawingCommand implements CommandExecutor {

    private final Command command;
    public StartDrawingCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.drawer().setDrawing(true);
    }
}
