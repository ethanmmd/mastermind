package ethanmmd.mastermind.models;

public class SessionImplementation implements Session {

    private final Game game;
    private final GameRegistry gameRegistry;
    private final Status status;

    public SessionImplementation() {
        this.game = new Game();
        this.gameRegistry = new GameRegistry(this.game);
        this.status = new Status();
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

    public GameStatus getGameStatus() {
        return this.status.getGameStatus();
    }

}
