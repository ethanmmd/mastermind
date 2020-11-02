package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.models.Result;
import ethanmmd.mastermind.views.MessageView;

public class ResultView {

    public void show(Result result) {
        MessageView.RESULT.writeln(result.getBlacks(), result.getWhites());
    }

}
