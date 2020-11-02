package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithConsoleView;

public class ProposedCombinationView extends WithConsoleView {

    public String show() {
        MessageView.PROPOSED_COMBINATION.write();
        return this.console.readString();
    }

}
