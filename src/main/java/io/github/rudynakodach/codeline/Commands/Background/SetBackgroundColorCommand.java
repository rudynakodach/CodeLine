package io.github.rudynakodach.codeline.Commands.Background;

import io.github.rudynakodach.codeline.Commands.CommandExecutor;
import io.github.rudynakodach.codeline.Utils.Commands.Command;

import java.awt.*;

public class SetBackgroundColorCommand implements CommandExecutor {

    private final Command command;

    public SetBackgroundColorCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        Color currentColor = command.drawer().graphics.getColor();

        command.drawer().graphics.setColor(new Color(Integer.parseInt(command.args()[0]), Integer.parseInt(command.args()[1]), Integer.parseInt(command.args()[2])));
        command.drawer().graphics.fillRect(0, 0, 400, 400);

        command.drawer().graphics.setColor(currentColor);
    }
}
