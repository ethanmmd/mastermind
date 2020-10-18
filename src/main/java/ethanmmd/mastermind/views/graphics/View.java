package ethanmmd.mastermind.views.graphics;

import ethanmmd.mastermind.controllers.Controller;
import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.controllers.ResumeController;
import ethanmmd.mastermind.controllers.StartController;
import ethanmmd.mastermind.views.ResumeView;

public class View extends ethanmmd.mastermind.views.View {

    private StartView startView;
    private ProposalView proposalView;
    private ResumeView resumeView;

    public View() {
        this.startView = new StartView();
        this.proposalView = new ProposalView();
        this.resumeView = new ResumeView();
    }

    @Override
    public void interact(Controller controller) {
        if (controller instanceof StartController) {
            this.startView.interact((StartController) controller);
        } else {
            if (controller instanceof ProposalController) {
                this.proposalView.interact((ProposalController) controller);
            } else {
                this.resumeView.interact((ResumeController) controller);
            }
        }

    }
}
