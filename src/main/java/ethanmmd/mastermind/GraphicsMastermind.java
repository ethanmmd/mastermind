package ethanmmd.mastermind;


import ethanmmd.mastermind.views.graphics.View;

class GraphicsMastermind extends Mastermind {

    @Override
    protected View createView() {
        return new View();
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }
}
