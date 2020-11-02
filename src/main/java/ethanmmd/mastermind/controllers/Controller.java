package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.models.Status;

public abstract class Controller {

    protected Game game;
    protected Status status;

    public Controller(Game game, Status status) {
        this.game = game;
        this.status = status;
    }

    public void next() {
        this.status.next();
    }

    public abstract void control();

}
