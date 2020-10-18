package ethanmmd.mastermind.views.graphics;


import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithConsoleView;
import ethanmmd.utils.WithGraphicsView;

class ProposalView extends WithGraphicsView {

    private Game game;

    private SecretCombinationView secretCombinationView;

    ProposalView(Game game) {
        this.game = game;
        this.secretCombinationView = new SecretCombinationView();
    }

    boolean interact() {
        ProposedCombination proposedCombination = new ProposedCombination();
        ProposedCombinationView proposedCombinationView = new ProposedCombinationView(proposedCombination);
        proposedCombinationView.read();
        this.game.addProposedCombination(proposedCombination);
        this.console.writeln();
        MessageView.ATTEMPTS.writeln(this.game.getAttempts());
        this.secretCombinationView.writeln();
        for (int i = 0; i < this.game.getAttempts(); i++) {
            new ProposedCombinationView(this.game.getProposedCombination(i)).write();
            new ResultView(this.game.getResult(i)).writeln();
        }
        if (this.game.isWinner()) {
            MessageView.WINNER.writeln();
            return true;
        } else if (this.game.isLooser()) {
            MessageView.LOOSER.writeln();
            return true;
        }
        return false;
    }

}
