package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.distributed.TCPIP;
import ethanmmd.mastermind.distributed.dispatchers.FrameType;
import ethanmmd.mastermind.models.GameStatus;
import ethanmmd.mastermind.models.Session;

import java.util.EnumMap;

public class Logic {

    private TCPIP tcpip;
    private final Session session;
    private EnumMap<GameStatus, AcceptorController> controllerMap;
    protected StartController startController;
    protected ProposalController proposalController;
    protected ResumeController resumeController;


    public Logic(boolean isStandalone) {
        this.tcpip = isStandalone ? null : TCPIP.createClientSocket();
        this.session = new Session(this.tcpip);
        this.controllerMap = new EnumMap<>(GameStatus.class);
        this.startController = new StartController(this.session, this.tcpip);
        this.proposalController = new ProposalController(this.session, this.tcpip);
        this.resumeController = new ResumeController(this.session, this.tcpip);
        this.controllerMap.put(GameStatus.STARTED, this.startController);
        this.controllerMap.put(GameStatus.PROPOSED, this.proposalController);
        this.controllerMap.put(GameStatus.RESUMED, this.resumeController);
        this.controllerMap.put(GameStatus.EXIT, null);
    }

    public AcceptorController getController() {
        return this.controllerMap.get(this.session.getGameState());
    }

    public void close() {
        this.tcpip.send(FrameType.CLOSE.name());
        this.tcpip.close();

    }
}
