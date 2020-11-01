package ethanmmd.mastermind.views;


import ethanmmd.mastermind.controllers.ResumeController;
import ethanmmd.utils.YesNoDialog;

public class ResumeView {

    public void interact(ResumeController resumeController) {
        resumeController.resume(new YesNoDialog().read(MessageView.RESUME.getMessage()));
    }
}
