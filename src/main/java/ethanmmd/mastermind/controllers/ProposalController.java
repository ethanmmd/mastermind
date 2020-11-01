package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.distributed.TCPIP;
import ethanmmd.mastermind.distributed.dispatchers.FrameType;
import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.models.Result;
import ethanmmd.mastermind.models.Session;

import static java.util.Objects.isNull;

public class ProposalController extends AcceptorController {

    private final ActionController actionController;
    private final UndoController undoController;
    private final RedoController redoController;

    public ProposalController(Session session, TCPIP tcpip) {
        super(session, tcpip);
        this.actionController = new ActionController(this.session);
        this.undoController = new UndoController(this.session);
        this.redoController = new RedoController(this.session);
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        if (isNull(this.tcpip)) {
            this.actionController.addProposedCombination(proposedCombination);
        } else {
            this.tcpip.send(FrameType.ADD_PROPOSED_COMBINATION.name());
            this.tcpip.sendProposedCombination(proposedCombination);
        }
    }

    public int getAttempts() {
        if (isNull(this.tcpip)) {
            return this.actionController.getAttempts();
        }
        this.tcpip.send(FrameType.GET_ATTEMPTS.name());
        return this.tcpip.receiveInt();
    }

    public ProposedCombination getProposedCombination(int position) {
        if (isNull(this.tcpip)) {
            return this.actionController.getProposedCombination(position);
        }
        this.tcpip.send(FrameType.GET_PROPOSAL_COMBINATION.name());
        this.tcpip.send(position);
        return this.tcpip.receiveProposedCombination();

    }

    public Result getResult(int position) {
        if (isNull(this.tcpip)) {
            return this.actionController.getResult(position);
        }
        this.tcpip.send(FrameType.GET_RESULT.name());
        this.tcpip.send(position);
        int blacks = this.tcpip.receiveInt();
        int whites = this.tcpip.receiveInt();
        return new Result(blacks, whites);

    }

    public boolean isLooser() {
        if (isNull(this.tcpip)) {
            return this.actionController.isLooser();
        }
        this.tcpip.send(FrameType.IS_LOOSER.name());
        return this.tcpip.receiveBoolean();


    }

    public boolean isWinner() {
        if (isNull(this.tcpip)) {
            return this.actionController.isWinner();
        }
        this.tcpip.send(FrameType.IS_WINNER.name());
        return this.tcpip.receiveBoolean();

    }

    public void undo() {
        if (isNull(this.tcpip)) {
            this.undoController.undo();
        } else {
            this.tcpip.send(FrameType.UNDO.name());
        }
    }

    public boolean undoable() {
        if (isNull(this.tcpip)) {
            return this.undoController.undoable();
        }
        this.tcpip.send(FrameType.UNDOABLE.name());
        return this.tcpip.receiveBoolean();

    }

    public void redo() {
        if (isNull(this.tcpip)) {
            this.redoController.redo();
        } else {
            this.tcpip.send(FrameType.REDO.name());
        }
    }

    public boolean redoable() {
        if (isNull(this.tcpip)) {
            return this.redoController.redoable();
        }
        this.tcpip.send(FrameType.REDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);

    }
}
