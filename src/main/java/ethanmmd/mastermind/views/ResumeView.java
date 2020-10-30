package ethanmmd.mastermind.views;


import ethanmmd.mastermind.controllers.ResumeController;
import ethanmmd.utils.YesNoDialog;

public class ResumeView {

    public void interact(ResumeController resumeController) {
        MessageView.RESUME.write();
        boolean newGame = new YesNoDialog().read();
        if (newGame) {
            resumeController.resume();
        } else {
            resumeController.next();
        }
    }
}
