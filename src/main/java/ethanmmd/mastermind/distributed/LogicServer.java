package ethanmmd.mastermind.distributed;

import ethanmmd.mastermind.controllers.Logic;
import ethanmmd.mastermind.distributed.dispatchers.*;

import static ethanmmd.mastermind.distributed.dispatchers.FrameType.*;

public class LogicServer extends Logic {

    public LogicServer(boolean isStandalone) {
        super(isStandalone);
    }

    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(START, new StartDispatcher(this.startController));
        dispatcherPrototype.add(ADD_PROPOSED_COMBINATION, new AddProposalDispatcher(this.proposalController));
        dispatcherPrototype.add(GET_RESULT, new GetResultDispatcher(this.proposalController));
        dispatcherPrototype.add(GET_PROPOSAL_COMBINATION, new GetProposalDispatcher(this.proposalController));
        dispatcherPrototype.add(GET_ATTEMPTS, new GetAttemptsDispatcher(this.proposalController));
        dispatcherPrototype.add(STATUS, new StatusDispatcher(this.proposalController));
        dispatcherPrototype.add(UNDO, new UndoDispatcher(this.proposalController));
        dispatcherPrototype.add(REDO, new RedoDispatcher(this.proposalController));
        dispatcherPrototype.add(UNDOABLE, new UndoableDispatcher(this.proposalController));
        dispatcherPrototype.add(REDOABLE, new RedoableDispatcher(this.proposalController));
        dispatcherPrototype.add(IS_WINNER, new IsWinnerDispatcher(this.proposalController));
        dispatcherPrototype.add(IS_LOOSER, new IsLooserDispatcher(this.proposalController));
        dispatcherPrototype.add(NEXT_STATUS, new NextStateDispatcher(this.proposalController));
        dispatcherPrototype.add(RESUME, new ResumeDispatcher(this.resumeController));


    }
}
