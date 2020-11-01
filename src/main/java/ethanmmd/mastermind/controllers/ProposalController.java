package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.models.Result;
import ethanmmd.mastermind.models.Session;

public abstract class ProposalController extends AcceptorController {

    public ProposalController(Session session) {
        super(session);
    }

    public abstract void addProposedCombination(ProposedCombination proposedCombination);

    public abstract int getAttempts();

    public abstract ProposedCombination getProposedCombination(int position);

    public abstract Result getResult(int position);

    public abstract boolean isLooser();

    public abstract boolean isWinner();

    public abstract void undo();

    public abstract boolean undoable();

    public abstract void redo();

    public abstract boolean redoable();

    public abstract void next();

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);

    }
}
