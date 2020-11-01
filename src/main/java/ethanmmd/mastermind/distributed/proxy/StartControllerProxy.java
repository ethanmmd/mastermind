package ethanmmd.mastermind.distributed.proxy;

import ethanmmd.mastermind.controllers.StartController;
import ethanmmd.mastermind.distributed.TCPIP;
import ethanmmd.mastermind.models.Session;

import static ethanmmd.mastermind.distributed.dispatchers.FrameType.START;

public class StartControllerProxy extends StartController {

    private final TCPIP tcpip;

    public StartControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void start() {
        this.tcpip.send(START.name());

    }
}
