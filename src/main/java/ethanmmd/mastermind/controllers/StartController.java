package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.models.Status;
import ethanmmd.mastermind.views.SecretCombinationView;
import ethanmmd.mastermind.views.StartView;

import static ethanmmd.mastermind.models.SecretCombination.getWidth;

public class StartController extends Controller {

    public StartController(Game game, Status status) {
        super(game, status);
    }

    @Override
    public void control() {
        new StartView().show();
        new SecretCombinationView().show(getWidth());
        this.next();
    }
}
