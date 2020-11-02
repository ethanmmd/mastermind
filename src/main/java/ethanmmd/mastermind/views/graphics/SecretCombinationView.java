package ethanmmd.mastermind.views.graphics;


import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithGraphicsView;

import static ethanmmd.mastermind.models.SecretCombination.getWidth;

class SecretCombinationView extends WithGraphicsView {

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
