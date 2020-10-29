package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.controllers.PlayController;
import ethanmmd.mastermind.controllers.StartController;
import ethanmmd.utils.Menu;

public class PlayMenu extends Menu {


    public PlayMenu(PlayController playController) {
        this.add(new ProposalCommand(playController));
        this.add(new UndoCommand(playController));
        this.add(new RedoCommand(playController));
    }
}
