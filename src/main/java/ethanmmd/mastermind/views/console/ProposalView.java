package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.controllers.PlayController;
import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithConsoleView;

class ProposalView extends WithConsoleView {

    private final PlayController playController;
    private final SecretCombinationView secretCombinationView;

    public ProposalView(PlayController playController) {
        this.playController = playController;
        this.secretCombinationView = new SecretCombinationView();
    }

    void write(ProposalController proposalController) {
        this.console.writeln();
        MessageView.ATTEMPTS.writeln(this.playController.getAttempts());
        this.secretCombinationView.writeln();
        for (int i = 0; i < this.playController.getAttempts(); i++) {
            new ProposedCombinationView(playController.getProposedCombination(i)).write();
            new ResultView(playController.getResult(i)).writeln();
        }
    }
}
