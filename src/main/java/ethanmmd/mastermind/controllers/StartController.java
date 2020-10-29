package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Session;

public class StartController extends UseCaseController implements AcceptorController {


    public StartController(Session session) {
        super(session);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);

    }
}
