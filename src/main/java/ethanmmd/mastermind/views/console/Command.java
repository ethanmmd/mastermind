package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.controllers.PlayController;
import ethanmmd.utils.AbstractCommand;

public abstract class Command extends AbstractCommand {

    protected final PlayController playController;

    public Command(String title, PlayController playController) {
        super(title);
        this.playController = playController;
    }
}
