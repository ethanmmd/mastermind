package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.models.Result;
import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithConsoleView;

class ResultView extends WithConsoleView {

    private Result result;

    ResultView(Result result) {
        this.result = result;
    }

    void writeln() {
        MessageView.RESULT.writeln(this.result.getBlacks(), this.result.getWhites());
    }

}
