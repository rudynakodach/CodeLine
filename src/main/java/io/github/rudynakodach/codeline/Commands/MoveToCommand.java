package io.github.rudynakodach.codeline.Commands;

import io.github.rudynakodach.codeline.Utils.Commands.Command;

import java.awt.*;

public class MoveToCommand implements CommandExecutor {
    private final Command command;
    public MoveToCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        System.out.println(command.drawer());
        command.drawer().moveTo(new Point(Integer.parseInt(command.args()[0]), Integer.parseInt(command.args()[1])));
    }

}
