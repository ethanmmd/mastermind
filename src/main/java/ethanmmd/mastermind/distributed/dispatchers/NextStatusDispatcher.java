package ethanmmd.mastermind.distributed.dispatchers;

import ethanmmd.mastermind.controllers.ProposalController;

public class NextStatusDispatcher extends Dispatcher {

    public NextStatusDispatcher(ProposalController proposalController) {
        super(proposalController);
    }

    @Override
    public void dispatch() {
        ((ProposalController) this.acceptorController).next();

    }
}
