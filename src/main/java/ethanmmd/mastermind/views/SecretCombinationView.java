package ethanmmd.mastermind.views;


import ethanmmd.utils.WithConsoleView;

public class SecretCombinationView extends WithConsoleView {

    public SecretCombinationView() {
        super();
    }

    public void show(int width) {
        for (int i = 0; i < width; i++) {
            MessageView.SECRET.write();
        }
        this.console.writeln();
    }

}
