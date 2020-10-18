package ethanmmd.mastermind;


import ethanmmd.mastermind.controllers.Logic;
import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.controllers.ResumeController;
import ethanmmd.mastermind.views.console.View;

class ConsoleMastermind extends Mastermind {

    @Override
    protected View createView(Logic logic) {
        return new View(logic);
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }
}
