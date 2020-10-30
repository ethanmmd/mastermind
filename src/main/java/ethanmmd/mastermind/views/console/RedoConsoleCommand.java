package ethanmmd.mastermind.views.console;

import ethanmmd.mastermind.controllers.ProposalController;

import static ethanmmd.mastermind.views.MessageView.REDO_COMMAND;

public class RedoConsoleCommand extends ConsoleCommand {

    public RedoConsoleCommand(ProposalController proposalController) {
        super(REDO_COMMAND.getMessage(), proposalController);
    }

    @Override
    public void execute() {
        this.proposalController.redo();
    }

    @Override
    public boolean isActive() {
        return proposalController.redoable();
    }
}
