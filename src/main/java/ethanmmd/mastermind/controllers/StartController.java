package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.distributed.TCPIP;
import ethanmmd.mastermind.distributed.dispatchers.FrameType;
import ethanmmd.mastermind.models.Session;

import static java.util.Objects.isNull;

public class StartController extends AcceptorController {

    public StartController(Session session, TCPIP tcpip) {
        super(session, tcpip);
    }

    public void start() {
        if (isNull(this.tcpip)) {
            this.session.next();
        } else {
            this.tcpip.send(FrameType.START.name());
        }
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);

    }
}
