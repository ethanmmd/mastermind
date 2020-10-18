package ethanmmd.mastermind.views.console;

import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.views.ResumeView;

public class View extends ethanmmd.mastermind.views.View {

    private StartView startView;
    private ProposalView proposalView;
    private ResumeView resumeView;

    public View(Game game) {
        super(game);
        this.startView = new StartView();
        this.proposalView = new ProposalView(this.game);
        this.resumeView = new ResumeView(this.game);
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
