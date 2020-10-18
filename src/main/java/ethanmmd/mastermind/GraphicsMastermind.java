package ethanmmd.mastermind;


import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.controllers.ResumeController;
import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.views.graphics.View;

class GraphicsMastermind extends Mastermind {

    @Override
    protected View createView(ProposalController proposalController, ResumeController resumeController) {
        return new View(proposalController, resumeController);
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }
}
