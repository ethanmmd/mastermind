package ethanmmd.mastermind.distributed.dispatchers;

import ethanmmd.mastermind.controllers.AcceptorController;
import ethanmmd.mastermind.distributed.TCPIP;

public abstract class Dispatcher {

    protected AcceptorController acceptorController;
    protected TCPIP tcpip;

    public Dispatcher(AcceptorController acceptorController) {
        this.acceptorController = acceptorController;
    }

    public abstract void dispatch();

    public void associate(TCPIP tcpip) {
        this.tcpip = tcpip;
    }

}

