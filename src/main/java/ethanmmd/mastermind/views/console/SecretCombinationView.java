package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithConsoleView;

import static ethanmmd.mastermind.models.SecretCombination.getWidth;

class SecretCombinationView extends WithConsoleView {

    SecretCombinationView() {
        super();
    }

    void writeln() {
        for (int i = 0; i < getWidth(); i++) {
            MessageView.SECRET.write();
        }
        this.console.writeln();
    }

}
