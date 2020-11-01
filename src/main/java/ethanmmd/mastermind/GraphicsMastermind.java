package ethanmmd.mastermind;


import ethanmmd.mastermind.controllers.Logic;
import ethanmmd.mastermind.views.graphics.GraphicsView;

class GraphicsMastermind extends Mastermind {

    @Override
    protected GraphicsView createView() {
        return new GraphicsView();
    }

    @Override
    protected Logic createLogic() {
        return null;
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }
}
