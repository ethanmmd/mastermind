package ethanmmd.mastermind.views;


import ethanmmd.utils.WithConsoleView;

public class ProposalView extends WithConsoleView {

    public void show(int attempts) {
        this.console.writeln();
        MessageView.ATTEMPTS.writeln(attempts);
    }
}
