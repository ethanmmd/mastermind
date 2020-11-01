package ethanmmd.mastermind.controllers.implementation;

import ethanmmd.mastermind.controllers.StartController;
import ethanmmd.mastermind.models.Session;
import ethanmmd.mastermind.models.SessionImplementation;

public class StartControllerImplementation extends StartController {

    SessionImplementation sessionImplementation;


    public StartControllerImplementation(Session session) {
        super(session);
        this.sessionImplementation = (SessionImplementation) session;
    }

    @Override
    public void start() {
        this.sessionImplementation.next();

    }
}
