package ethanmmd.mastermind;


import ethanmmd.mastermind.views.graphics.GraphicsView;

class GraphicsMastermind extends Mastermind {

    @Override
    protected GraphicsView createView() {
        return new GraphicsView();
    }

    @Override
    protected boolean isStandalone() {
        return true;
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }
}
