package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.models.Result;
import ethanmmd.mastermind.models.Session;

public class ActionController extends Controller {

    public ActionController(Session session) {
        super(session);
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.session.addProposedCombination(proposedCombination);
    }

    boolean isLooser() {
        return this.session.isLooser();
    }

    boolean isWinner() {
        return this.session.isWinner();
    }

    int getAttempts() {
        return this.session.getAttempts();
    }

    ProposedCombination getProposedCombination(int position) {
        return this.session.getProposedCombination(position);
    }

    Result getResult(int position) {
        return this.session.getResult(position);
    }


}

