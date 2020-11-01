package ethanmmd.mastermind.controllers.implementation;

import ethanmmd.mastermind.controllers.ControllerVisitor;
import ethanmmd.mastermind.controllers.ResumeController;
import ethanmmd.mastermind.models.Session;
import ethanmmd.mastermind.models.SessionImplementation;

public class ResumeControllerImplementation extends ResumeController {

    SessionImplementation sessionImplementation;

    public ResumeControllerImplementation(Session session) {
        super(session);
        this.sessionImplementation = (SessionImplementation) session;
    }

    public void resume(boolean newGame) {
        if (newGame) {
            this.sessionImplementation.clear();
        } else {
            this.sessionImplementation.next();
        }
    }

    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
}
