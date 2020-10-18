package ethanmmd.mastermind.views.graphics;

import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.controllers.ResumeController;
import ethanmmd.mastermind.views.ResumeView;

public class View extends ethanmmd.mastermind.views.View {

    private StartView startView;
    private ProposalView proposalView;
    private ResumeView resumeView;

    public View(ProposalController proposalController, ResumeController resumeController) {
        this.startView = new StartView();
        this.proposalView = new ProposalView(proposalController);
        this.resumeView = new ResumeView(resumeController);
    }

    @Override
    protected void start() {
        this.startView.interact();

    }

    @Override
    protected boolean propose() {
        return this.proposalView.interact();

    }


    @Override
    protected boolean resume() {
        return this.resumeView.interact();

    }
}
