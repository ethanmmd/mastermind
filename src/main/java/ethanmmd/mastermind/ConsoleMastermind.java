package ethanmmd.mastermind;


import ethanmmd.mastermind.views.console.View;

class ConsoleMastermind extends Mastermind {

    @Override
    protected View createView() {
        return new View();
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }
}
