package ethanmmd.mastermind.views.console;

import ethanmmd.utils.ClosedInterval;
import ethanmmd.utils.Console;

import java.util.ArrayList;
import java.util.List;

abstract class Menu {

    private static final String TITLE_OPTION = "----- Choose one option -----";
    private final List<ConsoleCommand> consoleCommands;

    public Menu() {
        this.consoleCommands = new ArrayList<>();
    }

    public void execute() {
        List<ConsoleCommand> activeConsoleCommands = new ArrayList<>();
        for (int i = 0; i < this.consoleCommands.size(); i++) {
            if (this.consoleCommands.get(i).isActive()) {
                activeConsoleCommands.add(this.consoleCommands.get(i));
            }
        }
        int option;
        Console console = Console.instance();
        boolean error;
        do {
            error = false;
            console.writeln();
            console.writeln(TITLE_OPTION);
            for (int i = 0; i < activeConsoleCommands.size(); i++) {
                console.writeln((i + 1) + ") " + activeConsoleCommands.get(i).getName());
            }
            option = console.readInt("") - 1;
            if (!new ClosedInterval(0, consoleCommands.size() - 1).isIncluded(option)) {
                error = true;
            }
        } while (error);
        activeConsoleCommands.get(option).execute();
    }

    protected void addCommand(ConsoleCommand consoleCommand) {
        this.consoleCommands.add(consoleCommand);
    }


}
