package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Session;

public abstract class UseCaseController {

    protected final Session session;

    public UseCaseController(Session session) {
        this.session = session;
    }

    public void next() {
        this.session.next();
    }
}
