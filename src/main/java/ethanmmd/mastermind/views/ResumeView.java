package ethanmmd.mastermind.views;


import ethanmmd.mastermind.controllers.Logic;
import ethanmmd.mastermind.controllers.ResumeLogic;
import ethanmmd.utils.YesNoDialog;

public class ResumeView {

    private ResumeLogic resumeLogic;

    public ResumeView(ResumeLogic resumeLogic) {
        this.resumeLogic = resumeLogic;
    }

    public boolean interact() {
        MessageView.RESUME.write();
        boolean newGame = new YesNoDialog().read();
        if (newGame) {
            this.resumeLogic.clear();
        }
        return newGame;
    }

}
