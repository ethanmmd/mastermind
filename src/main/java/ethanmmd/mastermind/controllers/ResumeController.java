package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.models.Status;
import ethanmmd.mastermind.views.ResumeView;
import ethanmmd.utils.YesNoDialog;

public class ResumeController extends Controller {

    public ResumeController(Game game, Status status) {
        super(game, status);
    }

    @Override
    public void control() {
        new ResumeView().interact();
        boolean newGame = new YesNoDialog().read();
        if (newGame) {
            this.game.clear();
            this.status.reset();
        } else {
            this.status.next();
        }
    }
}
