package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.distributed.TCPIP;
import ethanmmd.mastermind.distributed.dispatchers.FrameType;
import ethanmmd.mastermind.models.Session;

import static java.util.Objects.isNull;

public class ResumeController extends AcceptorController {

    ResumeController(Session session, TCPIP tcpip) {
        super(session, tcpip);
    }

    public void resume(boolean newGame) {
        if (isNull(this.tcpip)) {
            if (newGame) {
                this.session.clear();
            } else {
                this.session.next();
            }
        } else {
            this.tcpip.send(FrameType.RESUME.name());
            this.tcpip.send(newGame);
        }

        this.session.clear();
    }

    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
