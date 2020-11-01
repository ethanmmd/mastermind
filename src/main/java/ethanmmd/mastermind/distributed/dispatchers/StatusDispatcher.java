package ethanmmd.mastermind.distributed.dispatchers;

import ethanmmd.mastermind.controllers.ProposalController;

public class StatusDispatcher extends Dispatcher {

    public StatusDispatcher(ProposalController proposalController) {
        super(proposalController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(this.acceptorController.getGameStatus().ordinal());

    }
}
