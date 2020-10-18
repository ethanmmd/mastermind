package ethanmmd.mastermind;


import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.views.graphics.View;

class GraphicsMastermind extends Mastermind {

    @Override
    protected View createView(Game game) {
        return new View(game);
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }
}
