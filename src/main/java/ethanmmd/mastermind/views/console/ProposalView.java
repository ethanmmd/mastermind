package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithConsoleView;

class ProposalView extends WithConsoleView {

    private SecretCombinationView secretCombinationView;

    private ProposalController proposalController;

    public ProposalView(ProposalController proposalController) {
        this.proposalController = proposalController;
        this.secretCombinationView = new SecretCombinationView();
    }

    boolean interact() {
        ProposedCombination proposedCombination = new ProposedCombination();
        ProposedCombinationView proposedCombinationView = new ProposedCombinationView(proposedCombination);
        proposedCombinationView.read();
        this.proposalController.addProposedCombination(proposedCombination);
        this.console.writeln();
        MessageView.ATTEMPTS.writeln(this.proposalController.getAttempts());
        this.secretCombinationView.writeln();
        for (int i = 0; i < this.proposalController.getAttempts(); i++) {
            new ProposedCombinationView(this.proposalController.getProposedCombination(i)).write();
            new ResultView(this.proposalController.getResult(i)).writeln();
        }
        if (this.proposalController.isWinner()) {
            MessageView.WINNER.writeln();
            return true;
        } else if (this.proposalController.isLooser()) {
            MessageView.LOOSER.writeln();
            return true;
        }
        return false;
    }

}
