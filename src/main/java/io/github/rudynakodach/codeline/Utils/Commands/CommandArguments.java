package io.github.rudynakodach.codeline.Utils.Commands;

import java.util.Arrays;
import java.util.List;

public class CommandArguments {

    private final List<List<ArgType>> params;

    public CommandArguments(List<ArgType> ...params) {
        this.params = Arrays.stream(params).toList();
    }

    public boolean isMatch(Command command) {

        System.out.println(params.size());
        int max = 0;
        for (List<ArgType> list : params) {
            if(list.size() > max) {
                max = list.size();
            }
        }

        if(max == 0) {return true;}
        else if(command.args().length == 0) {return false;}

        for(List<ArgType> list : params) {
            if(list.size() != command.args().length) {continue;}
            int total = list.size();
            int matching = 0;
            for (int i = 0; i < list.size(); i++) {
                ArgType provided = getArgType(command.args()[i]);
                ArgType expected = list.get(i);

                System.out.println("provided: " + provided);
                System.out.println("expected: " + expected);

                if(provided == expected) {
                    matching += 1;
                }
                System.out.println("provided:expected amt = " + matching + ":" + total);
            }
            if(total == matching) {
                return true;
            }
        }
        return false;
    }

    private ArgType getArgType(String arg) {
        try {
            Integer.parseInt(arg);
            return ArgType.INTEGER;
        } catch (NumberFormatException ignored) {
            return ArgType.STRING;
        }
    }
}
