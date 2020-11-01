package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.GameStatus;
import ethanmmd.mastermind.models.Session;

public abstract class Controller {

    protected Session session;

    Controller(Session session) {
        this.session = session;
    }

    public void next() {
        this.session.next();
    }

    public GameStatus getGameStatus() {
        return this.session.getGameState();
    }


}
