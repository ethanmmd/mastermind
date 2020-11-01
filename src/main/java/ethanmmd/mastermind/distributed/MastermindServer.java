package ethanmmd.mastermind.distributed;

import ethanmmd.mastermind.distributed.dispatchers.DispatcherPrototype;

public class MastermindServer {

    private final DispatcherPrototype dispatcherPrototype;
    private final LogicServer logicServer;

    public MastermindServer() {
        this.dispatcherPrototype = new DispatcherPrototype();
        this.logicServer = new LogicServer(true);
        this.logicServer.createDispatchers(this.dispatcherPrototype);
    }

    private void serve() {
        this.dispatcherPrototype.serve();
    }

    public static void main(String[] args) {
        new MastermindServer().serve();
    }

}
