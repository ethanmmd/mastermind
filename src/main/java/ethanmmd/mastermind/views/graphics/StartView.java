package ethanmmd.mastermind.views.graphics;


import ethanmmd.mastermind.views.MessageView;

class StartView {

    void interact() {
        MessageView.TITLE.writeln();
        new SecretCombinationView().writeln();
    }

}
