package ethanmmd.mastermind;


import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.views.console.View;

class ConsoleMastermind extends Mastermind {

    @Override
    protected View createView(Game game) {
        return new View(game);
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }
}
