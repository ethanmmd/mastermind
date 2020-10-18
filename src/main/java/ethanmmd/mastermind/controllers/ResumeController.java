package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.models.Status;

public class ResumeController extends Controller{

    public ResumeController(Game game, Status status) {
        super(game, status);
    }

    public void clear(){
        this.game.clear();
        this.status.reset();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);

    }




}
