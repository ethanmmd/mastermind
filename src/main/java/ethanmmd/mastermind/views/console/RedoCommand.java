package ethanmmd.mastermind.views.console;

import ethanmmd.mastermind.controllers.PlayController;
import ethanmmd.mastermind.views.MessageView;

public class RedoCommand extends Command {

    public RedoCommand(PlayController playController) {
        super(MessageView.REDO_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {
        this.playController.redo();
        new ProposalView(this.playController).write();
    }

    @Override
    protected boolean isActive() {
        return false;
    }
}
