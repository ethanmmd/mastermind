package ethanmmd.mastermind.views.console;

import ethanmmd.mastermind.controllers.ProposalController;

import static ethanmmd.mastermind.views.MessageView.UNDO_COMMAND;

public class UndoConsoleCommand extends ConsoleCommand {

    public UndoConsoleCommand(ProposalController proposalController) {
        super(UNDO_COMMAND.getMessage(), proposalController);
    }

    @Override
    public void execute() {

        this.proposalController.undo();

    }

    @Override
    public boolean isActive() {
        return this.proposalController.undoable();
    }
}
