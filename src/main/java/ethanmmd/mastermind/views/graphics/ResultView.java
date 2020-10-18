package ethanmmd.mastermind.views.graphics;


import ethanmmd.mastermind.models.Result;
import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithConsoleView;
import ethanmmd.utils.WithGraphicsView;

class ResultView {
	
	private Result result;

	ResultView(Result result) {
		this.result = result;
	}

	void writeln() {
		MessageView.RESULT.writeln(this.result.getBlacks(), this.result.getWhites());
	}

}
