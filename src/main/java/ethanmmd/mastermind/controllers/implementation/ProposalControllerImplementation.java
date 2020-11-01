package ethanmmd.mastermind.controllers.implementation;

import ethanmmd.mastermind.controllers.ActionController;
import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.controllers.RedoController;
import ethanmmd.mastermind.controllers.UndoController;
import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.models.Result;
import ethanmmd.mastermind.models.Session;

public class ProposalControllerImplementation extends ProposalController {

    private final ActionController actionController;
    private final UndoController undoController;
    private final RedoController redoController;

    public ProposalControllerImplementation(Session session) {
        super(session);
        this.actionController = new ActionController(this.session);
        this.undoController = new UndoController(this.session);
        this.redoController = new RedoController(this.session);
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.actionController.addProposedCombination(proposedCombination);
    }

    public boolean isLooser() {
        return this.actionController.isLooser();
    }

    public boolean isWinner() {
        return this.actionController.isWinner();
    }

    public int getAttempts() {
        return this.actionController.getAttempts();
    }

    public ProposedCombination getProposedCombination(int position) {
        return this.actionController.getProposedCombination(position);
    }

    public Result getResult(int position) {
        return this.actionController.getResult(position);
    }

    public void undo() {
        this.undoController.undo();
    }

    public boolean undoable() {
        return this.undoController.undoable();
    }

    public void redo() {
        this.redoController.redo();
    }

    public boolean redoable() {
        return this.redoController.redoable();
    }

    public void next() {
        this.actionController.next();
    }

}
