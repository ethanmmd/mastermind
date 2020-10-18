package ethanmmd.mastermind.views.graphics;


import ethanmmd.mastermind.models.SecretCombination;
import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithConsoleView;
import ethanmmd.utils.WithGraphicsView;

class SecretCombinationView extends WithGraphicsView {

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
