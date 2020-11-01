package ethanmmd.mastermind.distributed.proxy;

import ethanmmd.mastermind.controllers.Logic;
import ethanmmd.mastermind.distributed.TCPIP;
import ethanmmd.mastermind.models.GameStatus;

public class LogicProxy extends Logic {
    private final TCPIP tcpip;

    public LogicProxy() {
        this.tcpip = TCPIP.createClientSocket();
        this.session = new SessionProxy(this.tcpip);
        this.controllerMap.put(GameStatus.STARTED, new StartControllerProxy(this.session, this.tcpip));
        this.controllerMap.put(GameStatus.PROPOSED, new ProposalControllerProxy(this.session, this.tcpip));
        this.controllerMap.put(GameStatus.RESUMED, new ResumeControllerProxy(this.session, this.tcpip));
        this.controllerMap.put(GameStatus.EXIT, null);
    }
}
