package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.models.Result;
import ethanmmd.mastermind.models.Status;

public class ProposalController extends Controller {

    public ProposalController(Game game, Status status) {
        super(game, status);
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

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);

    }
}
