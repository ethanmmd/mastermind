package ethanmmd.mastermind.views.graphics;


import ethanmmd.mastermind.controllers.ProposalController;

class ProposalView {

    private ProposalController proposalController;
    private SecretCombinationView secretCombinationView;

    ProposalView(ProposalController proposalController) {
        this.proposalController = proposalController;
        this.secretCombinationView = new SecretCombinationView();
    }

    boolean interact() {
        return false;
    }

}
