package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.GameStatus;
import ethanmmd.mastermind.models.Session;

public abstract class Controller {

    protected Session session;

    Controller(Session session) {
        this.session = session;
    }

    public GameStatus getGameStatus() {
        return this.session.getGameStatus();
    }


}
