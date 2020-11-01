package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Session;

public abstract class AcceptorController extends Controller {


    AcceptorController(Session session) {
        super(session);
    }

    public abstract void accept(ControllerVisitor controllerVisitor);
}
