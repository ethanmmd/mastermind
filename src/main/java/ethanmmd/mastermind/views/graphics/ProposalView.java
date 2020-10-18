package ethanmmd.mastermind.views.graphics;


import ethanmmd.mastermind.controllers.Logic;
import ethanmmd.mastermind.controllers.ProposalLogic;

class ProposalView {

    private ProposalLogic proposalLogic;
    private final SecretCombinationView secretCombinationView;

    ProposalView(ProposalLogic proposalLogic) {
        this.proposalLogic = proposalLogic;
        this.secretCombinationView = new SecretCombinationView();
    }

    boolean interact() {
        return false;
    }

}
