package ethanmmd.mastermind.views.console;

import ethanmmd.mastermind.controllers.ProposalController;

class ProposalMenu extends Menu {

    ProposalMenu(ProposalController proposalController) {
        this.addCommand(new ProposalConsoleCommand(proposalController));
        this.addCommand(new UndoConsoleCommand(proposalController));
        this.addCommand(new RedoConsoleCommand(proposalController));

    }

}
