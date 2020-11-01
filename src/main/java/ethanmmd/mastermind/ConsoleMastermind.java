package ethanmmd.mastermind;


import ethanmmd.mastermind.views.console.ConsoleView;

class ConsoleMastermind extends Mastermind {

    @Override
    protected ConsoleView createView() {
        return new ConsoleView();
    }

    @Override
    protected boolean isStandalone() {
        return true;
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }
}
