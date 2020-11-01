package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Session;

public abstract class ResumeController extends AcceptorController {

    public ResumeController(Session session) {
        super(session);
    }

    public abstract void resume(boolean newGame);

    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
