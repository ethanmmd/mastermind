package ethanmmd.mastermind.views.console;

import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.models.ProposedCombination;

import static ethanmmd.mastermind.views.MessageView.PROPOSAL_COMMAND;

class ProposalConsoleCommand extends ConsoleCommand {


    public ProposalConsoleCommand(ProposalController proposalController) {
        super(PROPOSAL_COMMAND.getMessage(), proposalController);
    }

    @Override
    public void execute() {
        ProposedCombination proposedCombination = new ProposedCombination();
        ProposedCombinationView proposedCombinationView = new ProposedCombinationView(proposedCombination);
        proposedCombinationView.read();
        this.proposalController.addProposedCombination(proposedCombination);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
