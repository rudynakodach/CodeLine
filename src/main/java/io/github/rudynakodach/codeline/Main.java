package io.github.rudynakodach.codeline;

import io.github.rudynakodach.codeline.Commands.Background.SetBackgroundColorCommand;
import io.github.rudynakodach.codeline.Commands.Background.SetDrawingColorCommand;
import io.github.rudynakodach.codeline.Commands.MoveToCommand;
import io.github.rudynakodach.codeline.Commands.StartDrawingCommand;
import io.github.rudynakodach.codeline.Commands.StopDrawingCommand;
import io.github.rudynakodach.codeline.Utils.Commands.ArgType;
import io.github.rudynakodach.codeline.Utils.Commands.CommandArguments;
import io.github.rudynakodach.codeline.Utils.Commands.CommandData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    static final HashMap<String, CommandData> commands = new HashMap<>() {{
        put("goto", new CommandData(MoveToCommand.class, new CommandArguments(new ArrayList<>(List.of(ArgType.INTEGER, ArgType.INTEGER)))));
        put("stpd", new CommandData(StopDrawingCommand.class, new CommandArguments(new ArrayList<>())));
        put("std", new CommandData(StartDrawingCommand.class, new CommandArguments(new ArrayList<>())));
        put("setbg", new CommandData(SetBackgroundColorCommand.class, new CommandArguments(new ArrayList<>(List.of(ArgType.INTEGER, ArgType.INTEGER, ArgType.INTEGER)))));
        put("setcol", new CommandData(SetDrawingColorCommand.class, new CommandArguments(new ArrayList<>(List.of(ArgType.INTEGER, ArgType.INTEGER, ArgType.INTEGER)))));
    }};
    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.prepareWindow();
        window.show();
    }
}