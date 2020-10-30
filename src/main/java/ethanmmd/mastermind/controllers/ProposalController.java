package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.models.Result;
import ethanmmd.mastermind.models.Session;

public class ProposalController extends Controller implements AcceptorController {

    private final ActionController actionController;
    private final UndoController undoController;
    private final RedoController redoController;

    public ProposalController(Session session) {
        super(session);
        this.actionController = new ActionController(this.session);
        this.undoController = new UndoController(this.session);
        this.redoController = new RedoController(this.session);
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.actionController.addProposedCombination(proposedCombination);
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

    public boolean isLooser() {
        return this.actionController.isLooser();
    }

    public boolean isWinner() {
        return this.actionController.isWinner();
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

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);

    }
}
