package ethanmmd.mastermind.views.graphics;


import ethanmmd.mastermind.models.Error;
import ethanmmd.utils.WithConsoleView;
import ethanmmd.utils.WithGraphicsView;

class ErrorView extends WithGraphicsView {

	private static final String[] MESSAGES = { 
			"Repeated colors",
			"Wrong colors, they must be: " + ColorView.allInitials(), 
			"Wrong proposed combination length" };

	private Error error;

	ErrorView(Error error) {
		this.error = error;
	}
	
	void writeln() {
		this.console.writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}

}
