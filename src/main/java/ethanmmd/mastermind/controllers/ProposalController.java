package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.models.Result;
import ethanmmd.mastermind.models.Session;

public class ProposalController extends UseCaseController {


    public ProposalController(Session session) {
        super(session);
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.session.addProposedCombination(proposedCombination);
    }

    public int getAttempts() {
        return this.session.getAttempts();
    }

    public ProposedCombination getProposedCombination(int position) {
        return this.session.getProposedCombination(position);
    }

    public Result getResult(int position) {
        return this.session.getResult(position);
    }

    public boolean isLooser() {
        return this.session.isLooser();
    }

    public boolean isWinner() {
        return this.session.isWinner();
    }

}
