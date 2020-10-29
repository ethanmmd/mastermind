package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Session;

public class UndoController extends UseCaseController {

    public UndoController(Session session) {
        super(session);
    }

    void undo() {
        this.session.undo();
    }

    boolean undoable() {
        return this.session.undoable();
    }

}
