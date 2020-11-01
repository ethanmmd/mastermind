package ethanmmd.mastermind;


import ethanmmd.mastermind.controllers.Logic;
import ethanmmd.mastermind.controllers.implementation.LogicImplementation;
import ethanmmd.mastermind.views.console.ConsoleView;

class ConsoleMastermind extends Mastermind {

    @Override
    protected ConsoleView createView() {
        return new ConsoleView();
    }

    @Override
    protected Logic createLogic() {
        return new LogicImplementation();
    }


    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }
}
