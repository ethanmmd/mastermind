package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.GameStatus;
import ethanmmd.mastermind.models.Session;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    protected Session session;
    protected Map<GameStatus, AcceptorController> controllerMap;

    public Logic() {
        this.controllerMap = new HashMap<>();
    }

    public AcceptorController getController() {
        return this.controllerMap.get(this.session.getGameStatus());
    }

}
