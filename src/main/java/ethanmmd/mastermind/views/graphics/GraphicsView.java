package ethanmmd.mastermind.views.graphics;

import ethanmmd.mastermind.controllers.*;
import ethanmmd.mastermind.views.ResumeView;

public class GraphicsView extends ethanmmd.mastermind.views.View implements ControllerVisitor {

    private StartView startView;
    private ProposalView proposalView;
    private ResumeView resumeView;

    public GraphicsView() {
        this.startView = new StartView();
        this.proposalView = new ProposalView();
        this.resumeView = new ResumeView();
    }

    @Override
    public void interact(AcceptorController acceptorController) {
        acceptorController.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        this.startView.interact(startController);
    }

    @Override
    public void visit(ProposalController proposalController) {
        this.proposalView.interact(proposalController);
    }

    @Override
    public void visit(ResumeController resumeController) {
        this.resumeView.interact(resumeController);
    }
}
