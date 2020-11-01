package ethanmmd.mastermind.distributed;

import ethanmmd.mastermind.distributed.dispatchers.DispatcherPrototype;

public class MastermindServer {

    private final DispatcherPrototype dispatcherPrototype;

    public MastermindServer() {
        this.dispatcherPrototype = new DispatcherPrototype();
        LogicServerImplementation logicServerImplementation = new LogicServerImplementation();
        logicServerImplementation.createDispatchers(this.dispatcherPrototype);
    }

    private void serve() {
        this.dispatcherPrototype.serve();
    }

    public static void main(String[] args) {
        new MastermindServer().serve();
    }

}
