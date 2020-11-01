package ethanmmd.mastermind.views.graphics;


import ethanmmd.mastermind.controllers.StartController;
import ethanmmd.mastermind.views.MessageView;

class StartView {

    void interact(StartController startController) {
        MessageView.TITLE.writeln();
        new SecretCombinationView().writeln();
        startController.next();
    }

}
