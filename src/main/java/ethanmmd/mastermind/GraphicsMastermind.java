package ethanmmd.mastermind;


import ethanmmd.mastermind.controllers.Logic;
import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.controllers.ResumeController;
import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.views.graphics.View;

class GraphicsMastermind extends Mastermind {

    @Override
    protected View createView(Logic logic) {
        return new View(logic);
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }
}
