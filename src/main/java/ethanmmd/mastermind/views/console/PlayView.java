package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.controllers.PlayController;

class PlayView {

    void interact(PlayController playController) {
        new PlayMenu(playController);
    }
}
