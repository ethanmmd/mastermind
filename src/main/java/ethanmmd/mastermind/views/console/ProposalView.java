package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.controllers.Logic;
import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.controllers.ProposalLogic;
import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithConsoleView;

class ProposalView extends WithConsoleView {

    private ProposalLogic proposalLogic;
    private SecretCombinationView secretCombinationView;

    public ProposalView(ProposalLogic proposalLogic) {
        this.proposalLogic = proposalLogic;
        this.secretCombinationView = new SecretCombinationView();
    }

    boolean interact() {
        ProposedCombination proposedCombination = new ProposedCombination();
        ProposedCombinationView proposedCombinationView = new ProposedCombinationView(proposedCombination);
        proposedCombinationView.read();
        this.proposalLogic.addProposedCombination(proposedCombination);
        this.console.writeln();
        MessageView.ATTEMPTS.writeln(this.proposalLogic.getAttempts());
        this.secretCombinationView.writeln();
        for (int i = 0; i < this.proposalLogic.getAttempts(); i++) {
            new ProposedCombinationView(this.proposalLogic.getProposedCombination(i)).write();
            new ResultView(this.proposalLogic.getResult(i)).writeln();
        }
        if (this.proposalLogic.isWinner()) {
            MessageView.WINNER.writeln();
            return true;
        } else if (this.proposalLogic.isLooser()) {
            MessageView.LOOSER.writeln();
            return true;
        }
        return false;
    }

}
