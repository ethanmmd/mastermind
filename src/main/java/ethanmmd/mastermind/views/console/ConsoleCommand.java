package ethanmmd.mastermind.views.console;

import ethanmmd.mastermind.controllers.ProposalController;

abstract class ConsoleCommand implements ethanmmd.utils.Command {

    protected String name;
    protected ProposalController proposalController;

    public ConsoleCommand(String name, ProposalController proposalController) {
        this.name = name;
        this.proposalController = proposalController;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
