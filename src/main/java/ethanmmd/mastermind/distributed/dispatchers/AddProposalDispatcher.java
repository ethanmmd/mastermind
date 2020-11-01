package ethanmmd.mastermind.distributed.dispatchers;

import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.models.ProposedCombination;

public class AddProposalDispatcher extends Dispatcher {

    public AddProposalDispatcher(ProposalController proposalController) {
        super(proposalController);
    }

    @Override
    public void dispatch() {
        ProposedCombination proposedCombination = this.tcpip.receiveProposedCombination();
        ((ProposalController) this.acceptorController).addProposedCombination(proposedCombination);
    }
}
