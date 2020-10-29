package ethanmmd.mastermind.models;

public class Session {

    private final Status status;
    private final Game game;
    private final GameRegistry gameRegistry;

    public Session() {
        this.status = new Status();
        this.game = new Game();
        this.gameRegistry = new GameRegistry(this.game);
    }

    public void next() {
        this.status.next();
    }

    public GameStatus getGameStatus() {
        return this.status.getGameStatus();
    }

    public boolean undoable() {
        return this.gameRegistry.undoable();
    }

    public boolean redoable() {
        return this.gameRegistry.redoable();
    }

    public void undo() {
        this.gameRegistry.undo();
    }

    public void redo() {
        this.gameRegistry.redo();
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.game.addProposedCombination(proposedCombination);
        this.gameRegistry.registry();
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

    public boolean isWinner() {
        boolean isWinner = this.game.isWinner();
        if (isWinner) {
            this.next();
        }
        return isWinner;
    }

    public boolean isLooser() {
        boolean isLooser = this.game.isLooser();
        if (isLooser) {
            this.next();
        }
        return isLooser;
    }

    public void reset() {
        this.game.clear();
        this.gameRegistry.reset();
        this.status.reset();
    }

}
