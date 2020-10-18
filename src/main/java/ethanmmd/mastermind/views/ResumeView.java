package ethanmmd.mastermind.views;


import ethanmmd.mastermind.controllers.ResumeController;
import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.YesNoDialog;

public class ResumeView {

	private ResumeController resumeController;

	public ResumeView(ResumeController resumeController) {
		this.resumeController = resumeController;
	}

	public boolean interact() {
		MessageView.RESUME.write();
		boolean newGame = new YesNoDialog().read();
		if (newGame) {
			this.resumeController.clear();
		}
		return newGame;
	}

}
