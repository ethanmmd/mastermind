package ethanmmd.mastermind.distributed.proxy;

import ethanmmd.mastermind.controllers.ResumeController;
import ethanmmd.mastermind.distributed.TCPIP;
import ethanmmd.mastermind.distributed.dispatchers.FrameType;
import ethanmmd.mastermind.models.Session;

import static ethanmmd.mastermind.distributed.dispatchers.FrameType.*;

public class ResumeControllerProxy extends ResumeController {

    private TCPIP tcpip;

    public ResumeControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void resume(boolean newGame) {
        this.tcpip.send(RESUME.name());
        this.tcpip.send(newGame);
    }
}
