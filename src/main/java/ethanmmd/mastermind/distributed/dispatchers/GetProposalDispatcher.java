package ethanmmd.mastermind.distributed.dispatchers;

import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.models.ProposedCombination;

public class GetProposalDispatcher extends Dispatcher {

    public GetProposalDispatcher(ProposalController proposalController) {
        super(proposalController);
    }

    @Override
    public void dispatch() {
        int position = this.tcpip.receiveInt();
        ProposedCombination proposedCombination = ((ProposalController) this.acceptorController).getProposedCombination(position);
        this.tcpip.sendProposedCombination(proposedCombination);
    }
}
