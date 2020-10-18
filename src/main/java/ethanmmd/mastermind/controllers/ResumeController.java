package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Game;

public class ResumeController extends Controller{

    public ResumeController(Game game) {
        super(game);
    }

    public void clear(){
        this.game.clear();
    }




}
