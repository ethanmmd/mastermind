package ethanmmd.mastermind.distributed.dispatchers;

import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.models.Result;

public class GetResultDispatcher extends Dispatcher {

    public GetResultDispatcher(ProposalController proposalController) {
        super(proposalController);
    }

    @Override
    public void dispatch() {
        int position = this.tcpip.receiveInt();
        Result result = ((ProposalController) this.acceptorController).getResult(position);
        this.tcpip.send(result.getBlacks());
        this.tcpip.send(result.getWhites());
    }
}
