package ethanmmd.mastermind;

import ethanmmd.mastermind.controllers.AcceptorController;
import ethanmmd.mastermind.controllers.Logic;
import ethanmmd.mastermind.views.View;

import static java.util.Objects.nonNull;

public abstract class Mastermind {

    private Logic logic;
    private View view;


    protected Mastermind() {
        this.logic = new Logic(this.isStandalone());
        this.view = this.createView();
    }

    protected void play() {
        AcceptorController controller;
        do {
            controller = this.logic.getController();
            if (nonNull(controller)) {
                this.view.interact(controller);
            }
        } while (nonNull(controller));
    }

    protected abstract View createView();

    protected abstract boolean isStandalone();
}
