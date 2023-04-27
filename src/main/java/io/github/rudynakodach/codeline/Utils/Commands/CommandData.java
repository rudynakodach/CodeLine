package io.github.rudynakodach.codeline.Utils.Commands;

import io.github.rudynakodach.codeline.Commands.CommandExecutor;

import java.lang.reflect.InvocationTargetException;

public class CommandData {
    private final Class<?> target;
    private final CommandArguments arguments;


    public CommandData(Class<?> target, CommandArguments arguments) {
        this.target = target;
        this.arguments = arguments;
    }

    public CommandExecutor getCommandExecutor(Command command) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (CommandExecutor) target.getDeclaredConstructor(Command.class).newInstance(command);
    }

    public CommandArguments getArguments() {
        return arguments;
    }

}
