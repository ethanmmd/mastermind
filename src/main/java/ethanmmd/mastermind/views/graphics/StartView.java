package ethanmmd.mastermind.views.graphics;


import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithGraphicsView;

class StartView extends WithGraphicsView {


    void interact() {
        MessageView.TITLE.writeln();
        new SecretCombinationView().writeln();
    }

}
