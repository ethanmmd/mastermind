package ethanmmd.mastermind.models;

import ethanmmd.mastermind.distributed.TCPIP;
import ethanmmd.mastermind.distributed.dispatchers.FrameType;

import static java.util.Objects.isNull;

public class Session {

    private final Game game;
    private final GameRegistry gameRegistry;
    private final Status status;
    private final TCPIP tcpip;

    public Session(TCPIP tcpip) {
        this.game = new Game();
        this.gameRegistry = new GameRegistry(this.game);
        this.status = new Status();
        this.tcpip = tcpip;
    }

    public void clear() {
        this.game.clear();
        this.gameRegistry.reset();
        this.status.reset();
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.game.addProposedCombination(proposedCombination);
        this.gameRegistry.registry();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public int getAttempts() {
        return this.game.getAttempts();
    }

    public ProposedCombination getProposedCombination(int position) {
        return this.game.getProposedCombination(position);
    }

    public Result getResult(int position) {
        return this.game.getResult(position);
    }

    public void undo() {
        this.gameRegistry.undo();
    }

    public void redo() {
        this.gameRegistry.redo();
    }

    public boolean undoable() {
        return this.gameRegistry.undoable();
    }

    public boolean redoable() {
        return this.gameRegistry.redoable();
    }

    public void next() {
        this.status.next();
    }

    public GameStatus getGameState() {
        if (isNull(this.tcpip)) {
            return this.status.getGameStatus();
        }
        this.tcpip.send(FrameType.STATUS.name());
        return GameStatus.values()[this.tcpip.receiveInt()];
    }
}
