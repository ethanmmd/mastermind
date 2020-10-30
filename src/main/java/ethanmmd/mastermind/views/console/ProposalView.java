package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithConsoleView;

class ProposalView extends WithConsoleView {

    private final SecretCombinationView secretCombinationView;

    public ProposalView() {
        this.secretCombinationView = new SecretCombinationView();
    }

    void interact(ProposalController proposalController) {
        new ProposalMenu(proposalController).execute();
        this.console.writeln();
        MessageView.ATTEMPTS.writeln(proposalController.getAttempts());
        this.secretCombinationView.writeln();
        for (int i = 0; i < proposalController.getAttempts(); i++) {
            new ProposedCombinationView(proposalController.getProposedCombination(i)).write();
            new ResultView(proposalController.getResult(i)).writeln();
        }
        if (proposalController.isWinner()) {
            MessageView.WINNER.writeln();
            proposalController.next();
        } else if (proposalController.isLooser()) {
            MessageView.LOOSER.writeln();
            proposalController.next();
        }
    }

}
