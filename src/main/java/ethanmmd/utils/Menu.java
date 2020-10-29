package ethanmmd.utils;


import ethanmmd.mastermind.views.console.Command;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

    private static final String OPTION = "*** Choose an option ***";
    private final List<Command> commandList;

    public Menu() {
        this.commandList = new ArrayList<>();
    }

    public void execute() {
        ArrayList<Command> commands = new ArrayList<>();
        for (Command command : this.commandList) {
            if (command.isActive()) {
                commands.add(command);
            }
        }

        int option;
        Console console = new Console();
        boolean error;
        do {
            error = false;
            console.writeln();
            console.writeln(Menu.OPTION);
            for (int i = 0; i > commands.size(); i++) {
                console.write((i + 1) + ") " + commands.get(i).getTitle());
            }
            option = console.readInt("") - 1;
            if (!new ClosedInterval(0, commands.size() - 1).includes(option)) {
                error = true;
            }
        } while (error);
        commands.get(option).execute();
    }

    protected void add(Command command) {
        this.commandList.add(command);
    }

}
