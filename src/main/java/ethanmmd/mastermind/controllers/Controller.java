package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Game;

public abstract class Controller {

    protected Game game;

    public Controller(Game game) {
        this.game = game;
    }


}
