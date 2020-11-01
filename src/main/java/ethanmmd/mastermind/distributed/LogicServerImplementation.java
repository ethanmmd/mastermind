package ethanmmd.mastermind.distributed;

import ethanmmd.mastermind.controllers.implementation.LogicImplementation;
import ethanmmd.mastermind.distributed.dispatchers.*;

public class LogicServerImplementation extends LogicImplementation {

    void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.ADD_PROPOSED_COMBINATION, new AddProposalDispatcher(this.proposalControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_RESULT, new GetResultDispatcher(this.proposalControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_PROPOSAL_COMBINATION, new GetProposalDispatcher(this.proposalControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_ATTEMPTS, new GetAttemptsDispatcher(this.proposalControllerImplementation));
        dispatcherPrototype.add(FrameType.STATUS, new StatusDispatcher(this.proposalControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.proposalControllerImplementation));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.proposalControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.proposalControllerImplementation));
        dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.proposalControllerImplementation));
        dispatcherPrototype.add(FrameType.IS_WINNER, new IsWinnerDispatcher(this.proposalControllerImplementation));
        dispatcherPrototype.add(FrameType.IS_LOOSER, new IsLooserDispatcher(this.proposalControllerImplementation));
        dispatcherPrototype.add(FrameType.NEXT_STATUS, new NextStatusDispatcher(this.proposalControllerImplementation));
        dispatcherPrototype.add(FrameType.RESUME, new ResumeDispatcher(this.resumeControllerImplementation));

    }

}
