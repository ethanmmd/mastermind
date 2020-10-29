package ethanmmd.mastermind.views.console;

import ethanmmd.mastermind.controllers.PlayController;
import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.views.MessageView;

public class ProposalCommand extends Command {

    public ProposalCommand(PlayController playController) {
        super(MessageView.ACTION_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {
        ProposedCombination proposedCombination = new ProposedCombination();
        ProposedCombinationView proposedCombinationView = new ProposedCombinationView(proposedCombination);
        proposedCombinationView.read();
        this.playController.addProposedCombination(proposedCombination);
        new ProposalView(this.playController).write();
        if (this.playController.isWinner()) {
            MessageView.WINNER.writeln();
        } else if (this.playController.isLooser()) {
            MessageView.LOOSER.writeln();
        }
    }

    @Override
    protected boolean isActive() {
        return true;
    }
}
