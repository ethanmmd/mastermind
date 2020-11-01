package ethanmmd.mastermind.distributed.dispatchers;

import ethanmmd.mastermind.controllers.ProposalController;

public class IsLooserDispatcher extends Dispatcher {

    public IsLooserDispatcher(ProposalController proposalController) {
        super(proposalController);
    }

    @Override
    public void dispatch() {

        this.tcpip.send(((ProposalController) this.acceptorController).isLooser());
    }
}
