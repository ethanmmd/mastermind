package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.controllers.StartController;
import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithConsoleView;

class StartView extends WithConsoleView {

    void interact(StartController startController) {
        MessageView.TITLE.writeln();
        new SecretCombinationView().writeln();
        startController.start();
    }

}
