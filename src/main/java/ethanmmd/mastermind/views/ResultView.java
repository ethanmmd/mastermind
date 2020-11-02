package ethanmmd.mastermind.views;


import ethanmmd.mastermind.models.Result;

public class ResultView {

    public void show(Result result) {
        MessageView.RESULT.writeln(result.getBlacks(), result.getWhites());
    }

}
