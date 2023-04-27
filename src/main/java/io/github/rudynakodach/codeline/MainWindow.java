package io.github.rudynakodach.codeline;

import io.github.rudynakodach.codeline.Commands.CommandExecutor;
import io.github.rudynakodach.codeline.Utils.Commands.Command;
import io.github.rudynakodach.codeline.Utils.Commands.CommandData;
import io.github.rudynakodach.codeline.Utils.Drawer;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class MainWindow {
    private static MainWindow instance;
    HashMap<String, CommandData> commands = Main.commands;
    private final JFrame frame;
    public JTextField responseField;
    public JTextField commandField;

    private JPanel canvas;
    private Drawer drawer;
    public MainWindow() {
        frame = new JFrame("CodeLine");
        responseField = new JTextField();
        commandField = new JTextField();
    }

    /**
     * Prepares all elements of the main window.
     */
    public void prepareWindow() {
        frame.setSize(new Dimension(750, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        canvas = new JPanel();
        canvas.setSize(400, 400);
        canvas.setPreferredSize(new Dimension(400, 400));
        canvas.setBackground(Color.PINK);
        container.add(canvas);

        responseField.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(responseField);
        container.add(responseField);

        container.add(commandField);

        commandField.addActionListener(e -> {
            String commandName = commandField.getText().split(" ")[0];
            String[] commandArgs = Objects.requireNonNullElse(Arrays.copyOfRange(commandField.getText().split(" "), 1, commandField.getText().split(" ").length), new String[0]);

            responseField.setText(commandField.getText());
            commandField.setText("");

            Command command = new Command(drawer, commandArgs);

            if(commands.containsKey(commandName)) {
                try {
                    System.out.println("Command args: " + String.join(" ", commandArgs));
                    CommandExecutor commandExecutor = commands.get(commandName).getCommandExecutor(command);
                    commandExecutor.execute();
                } catch (InstantiationException | NoSuchMethodException | InvocationTargetException |
                         IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        commandField.addCaretListener(l -> {
            String commandName = commandField.getText().split(" ")[0];
            String[] commandArgs = Objects.requireNonNullElse(Arrays.copyOfRange(commandField.getText().split(" "), 1, commandField.getText().split(" ").length), new String[0]);
            Command command = new Command(drawer, commandArgs);

            if(!commands.containsKey(commandField.getText().split(" ")[0])) {
                commandField.setForeground(Color.RED);
            } else {
                if(Main.commands.containsKey(commandName)) {
                    if(Main.commands.get(commandName).getArguments().isMatch(command)) {
                        commandField.setForeground(Color.BLACK);
                    } else {
                        commandField.setForeground(Color.RED);
                    }
                }
            }
        });

        frame.add(container);
    }

    @Nullable
    public static MainWindow getInstance() {
        return instance;
    }

    /**
     * Displays the window.
     */
    public void show() {
        frame.setVisible(true);

        Graphics g = canvas.getGraphics();
        drawer = new Drawer(g);
    }
}
