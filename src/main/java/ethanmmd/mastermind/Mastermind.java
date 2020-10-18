package ethanmmd.mastermind;

import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.controllers.ResumeController;
import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.views.View;

public abstract class Mastermind {

    private Game game;
    private ProposalController proposalController;
    private ResumeController resumeController;
    private View view;


    protected Mastermind() {
        this.game = new Game();
        this.proposalController = new ProposalController(this.game);
        this.resumeController = new ResumeController(this.game);
        this.view = this.createView(this.proposalController, this.resumeController);

    }

    protected abstract View createView(ProposalController proposalController, ResumeController resumeController);

    protected void play() {
        this.view.interact();
    }
}
