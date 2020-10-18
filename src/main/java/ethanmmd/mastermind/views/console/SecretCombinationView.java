package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.models.SecretCombination;
import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithConsoleView;

class SecretCombinationView extends WithConsoleView {

    SecretCombinationView() {
        super();
    }

    void writeln() {
        for (int i = 0; i < SecretCombination.getWidth(); i++) {
            MessageView.SECRET.write();
        }
        this.console.writeln();
    }

}
