package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Session;

public class RedoController extends UseCaseController {

    public RedoController(Session session) {
        super(session);
    }

    public void redo() {
        this.session.redo();
    }

    public boolean redoable() {
        return this.session.redoable();
    }
}
