package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.models.Result;
import ethanmmd.mastermind.models.Session;
import ethanmmd.mastermind.models.SessionImplementation;

public class ActionController extends Controller {

    private final SessionImplementation sessionImplementation;

    public ActionController(Session session) {
        super(session);
        this.sessionImplementation = (SessionImplementation) session;
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.sessionImplementation.addProposedCombination(proposedCombination);
    }

    public boolean isLooser() {
        return this.sessionImplementation.isLooser();
    }

    public boolean isWinner() {
        return this.sessionImplementation.isWinner();
    }

    public int getAttempts() {
        return this.sessionImplementation.getAttempts();
    }

    public ProposedCombination getProposedCombination(int position) {
        return this.sessionImplementation.getProposedCombination(position);
    }

    public Result getResult(int position) {
        return this.sessionImplementation.getResult(position);
    }

    public void next() {
        this.sessionImplementation.next();
    }


}

