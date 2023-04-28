package io.github.rudynakodach.codeline.Commands.Background;

import io.github.rudynakodach.codeline.Commands.CommandExecutor;
import io.github.rudynakodach.codeline.Utils.Commands.Command;

import java.awt.*;

public class SetDrawingColorCommand implements CommandExecutor {

    private final Command command;

    public SetDrawingColorCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.drawer().graphics.setColor(new Color(
                Math.min(Integer.parseInt(command.args()[0]), 255),
                Math.min(Integer.parseInt(command.args()[1]), 255),
                Math.min(Integer.parseInt(command.args()[2]), 255)
        ));
    }
}
