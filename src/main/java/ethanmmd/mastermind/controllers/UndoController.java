package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Session;
import ethanmmd.mastermind.models.SessionImplementation;

public class UndoController extends Controller {

    private final SessionImplementation sessionImplementation;

    public UndoController(Session session) {
        super(session);
        this.sessionImplementation = (SessionImplementation) session;

    }

    public void undo() {
        this.sessionImplementation.undo();
    }

    public boolean undoable() {
        return this.sessionImplementation.undoable();
    }
}
