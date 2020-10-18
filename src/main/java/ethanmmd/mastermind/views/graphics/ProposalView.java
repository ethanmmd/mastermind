package ethanmmd.mastermind.views.graphics;


import ethanmmd.mastermind.controllers.ProposalController;

class ProposalView {

    private final SecretCombinationView secretCombinationView;

    ProposalView() {
        this.secretCombinationView = new SecretCombinationView();
    }

    void interact(ProposalController proposalController) {
        proposalController.next();
    }

}
