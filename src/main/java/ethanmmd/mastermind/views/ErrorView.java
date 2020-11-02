package ethanmmd.mastermind.views;


import ethanmmd.utils.WithConsoleView;

public class ErrorView extends WithConsoleView {

    private static final String[] MESSAGES = {
            "Repeated colors",
            "Wrong colors, they must be: " + ColorView.allInitials(),
            "Wrong proposed combination length"};

    public void show(int ordinal) {
        this.console.writeln(ErrorView.MESSAGES[ordinal]);
    }

}
