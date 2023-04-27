package io.github.rudynakodach.codeline.Commands.Background;

import io.github.rudynakodach.codeline.Commands.CommandExecutor;
import io.github.rudynakodach.codeline.Utils.Drawer;

import java.awt.*;

public class SetBackgroundColorCommand implements CommandExecutor {

    private final Drawer drawer;
    private final String[] args;

    public SetBackgroundColorCommand(Drawer drawer, String[] args) {
        this.drawer = drawer;
        this.args = args;
    }

    @Override
    public void execute() {
        Color currentColor = drawer.graphics.getColor();

        drawer.graphics.setColor(new Color(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
        drawer.graphics.fillRect(0, 0, 400, 400);

        drawer.graphics.setColor(currentColor);
    }
}
