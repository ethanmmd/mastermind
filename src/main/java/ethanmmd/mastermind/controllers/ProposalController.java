package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.models.Result;

public class ProposalController {

    private Game game;

    public ProposalController(Game game) {
        this.game = game;
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.game.addProposedCombination(proposedCombination);
    }

    public int getAttempts() {
        return this.game.getAttempts();
    }

    public ProposedCombination getProposedCombination(int position) {
        return this.game.getProposedCombination(position);
    }

    public Result getResult(int position) {
        return this.game.getResult(position);
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }
}
