package ethanmmd.mastermind.controllers.implementation;

import ethanmmd.mastermind.controllers.Logic;
import ethanmmd.mastermind.models.SessionImplementation;

import static ethanmmd.mastermind.models.GameStatus.*;

public class LogicImplementation extends Logic {

    protected StartControllerImplementation startControllerImplementation;
    protected ProposalControllerImplementation proposalControllerImplementation;
    protected ResumeControllerImplementation resumeControllerImplementation;

    public LogicImplementation() {
        this.session = new SessionImplementation();
        this.startControllerImplementation = new StartControllerImplementation(this.session);
        this.proposalControllerImplementation = new ProposalControllerImplementation(this.session);
        this.resumeControllerImplementation = new ResumeControllerImplementation(this.session);
        this.controllerMap.put(STARTED, this.startControllerImplementation);
        this.controllerMap.put(PROPOSED, this.proposalControllerImplementation);
        this.controllerMap.put(RESUMED, this.resumeControllerImplementation);
        this.controllerMap.put(EXIT, null);

    }
}
