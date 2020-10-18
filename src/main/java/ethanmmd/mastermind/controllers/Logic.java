package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.models.GameStatus;
import ethanmmd.mastermind.models.Status;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    private Game game;
    private Status status;
    private Map<GameStatus, Controller> controllerMap;


    public Logic() {
        this.status = new Status();
        this.game = new Game();
        this.controllerMap = new HashMap<>();
        this.controllerMap.put(GameStatus.STARTED, new StartController(this.game, this.status));
        this.controllerMap.put(GameStatus.PROPOSED, new ProposalController(this.game, this.status));
        this.controllerMap.put(GameStatus.RESUMED, new ResumeController(this.game, this.status));
        this.controllerMap.put(GameStatus.EXIT, null);
    }

    public Controller getController() {
        return this.controllerMap.get(this.status.getGameStatus());
    }
}
