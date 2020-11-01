package ethanmmd.mastermind.distributed.proxy;

import ethanmmd.mastermind.distributed.TCPIP;
import ethanmmd.mastermind.models.GameStatus;
import ethanmmd.mastermind.models.Session;

import static ethanmmd.mastermind.distributed.dispatchers.FrameType.STATUS;

public class SessionProxy implements Session {

    private TCPIP tcpip;

    public SessionProxy(TCPIP tcpip) {
        this.tcpip = tcpip;
    }

    @Override
    public GameStatus getGameStatus() {
        this.tcpip.send(STATUS.name());
        return GameStatus.values()[this.tcpip.receiveInt()];

    }
}
