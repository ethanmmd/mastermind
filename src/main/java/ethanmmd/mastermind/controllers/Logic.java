package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.GameStatus;
import ethanmmd.mastermind.models.Session;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    private final Session session;
    private Map<GameStatus, AcceptorController> controllerMap;


    public Logic() {
        this.session = new Session();
        this.controllerMap = new HashMap<>();
        this.controllerMap.put(GameStatus.STARTED, new StartController(this.session));
        this.controllerMap.put(GameStatus.PROPOSED, new PlayController(this.session));
        this.controllerMap.put(GameStatus.RESUMED, new ResumeController(this.session));
        this.controllerMap.put(GameStatus.EXIT, null);
    }

    public AcceptorController getController() {
        return this.controllerMap.get(this.session.getGameStatus());
    }
}
