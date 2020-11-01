package ethanmmd.mastermind.distributed.proxy;

import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.distributed.TCPIP;
import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.models.Result;
import ethanmmd.mastermind.models.Session;

import static ethanmmd.mastermind.distributed.dispatchers.FrameType.*;

public class ProposalControllerProxy extends ProposalController {

    private TCPIP tcpip;

    public ProposalControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.tcpip.send(ADD_PROPOSED_COMBINATION.name());
        this.tcpip.sendProposedCombination(proposedCombination);
    }

    public boolean isLooser() {
        this.tcpip.send(IS_LOOSER.name());
        return this.tcpip.receiveBoolean();
    }

    public boolean isWinner() {
        this.tcpip.send(IS_WINNER.name());
        return this.tcpip.receiveBoolean();
    }

    public int getAttempts() {
        this.tcpip.send(GET_ATTEMPTS.name());
        return this.tcpip.receiveInt();
    }

    public ProposedCombination getProposedCombination(int position) {
        this.tcpip.send(GET_PROPOSAL_COMBINATION.name());
        this.tcpip.send(position);
        return this.tcpip.receiveProposedCombination();
    }

    public Result getResult(int position) {
        this.tcpip.send(GET_RESULT.name());
        this.tcpip.send(position);
        int blacks = this.tcpip.receiveInt();
        int whites = this.tcpip.receiveInt();
        return new Result(blacks, whites);
    }

    public void undo() {
        this.tcpip.send(UNDO.name());
    }

    public boolean undoable() {
        this.tcpip.send(UNDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    public void redo() {
        this.tcpip.send(REDO.name());
    }

    public boolean redoable() {
        this.tcpip.send(REDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    public void next() {
        this.tcpip.send(NEXT_STATUS.name());
    }

}
