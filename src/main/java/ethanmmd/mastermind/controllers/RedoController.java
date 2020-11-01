package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Session;
import ethanmmd.mastermind.models.SessionImplementation;

public class RedoController extends Controller {

    private final SessionImplementation sessionImplementation;

    public RedoController(Session session) {
        super(session);
        this.sessionImplementation = (SessionImplementation) session;

    }

    public void redo() {
        this.sessionImplementation.redo();
    }

    public boolean redoable() {
        return this.sessionImplementation.redoable();
    }
}
