package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithConsoleView;

class StartView extends WithConsoleView {

    void interact() {
        MessageView.TITLE.writeln();
        new SecretCombinationView().writeln();
    }

}
