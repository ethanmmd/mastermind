package ethanmmd.mastermind;

import ethanmmd.mastermind.controllers.Controller;
import ethanmmd.mastermind.controllers.ProposalController;
import ethanmmd.mastermind.controllers.ResumeController;
import ethanmmd.mastermind.controllers.StartController;
import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.models.GameStatus;
import ethanmmd.mastermind.models.Status;

import java.util.EnumMap;

import static java.util.Objects.nonNull;

public abstract class Mastermind {

    private Game game;
    private Status status;
    private EnumMap<GameStatus, Controller> controllerEnumMap;

    protected Mastermind() {
        this.game = new Game();
        this.status = new Status();
        this.controllerEnumMap = new EnumMap<>(GameStatus.class);
        this.controllerEnumMap.put(GameStatus.STARTED, new StartController(this.game, this.status));
        this.controllerEnumMap.put(GameStatus.PROPOSED, new ProposalController(this.game, this.status));
        this.controllerEnumMap.put(GameStatus.RESUMED, new ResumeController(this.game, this.status));
        this.controllerEnumMap.put(GameStatus.EXIT, null);
    }

    protected void play() {
        Controller controller;
        do {
            controller = this.controllerEnumMap.get(this.status.getGameStatus());
            if (nonNull(controller)) {
                controller.control();
            }
        } while (nonNull(controller));
    }
}
