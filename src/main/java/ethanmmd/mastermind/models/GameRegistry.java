package ethanmmd.mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class GameRegistry {

    private final Game game;
    private List<Game.GameVersion> gameVersions;
    private int firstPrevious;

    public GameRegistry(Game game) {
        this.game = game;
        this.reset();
    }

    void reset() {
        this.gameVersions = new ArrayList<>();
        this.firstPrevious = 0;
    }

    void registry() {
        for (int i = 0; i < this.firstPrevious; i++) {
            this.gameVersions.remove(0);
        }

        this.firstPrevious = 0;
        this.gameVersions.add(this.firstPrevious, this.game.createGameVersion());
    }

    void undo() {
        this.firstPrevious++;
        this.game.setGameVersion(this.gameVersions.get(this.firstPrevious));
    }

    void redo() {
        this.firstPrevious--;
        this.game.setGameVersion(this.gameVersions.get(this.firstPrevious));
    }

    boolean undoable() {
        return this.firstPrevious < this.gameVersions.size() - 1;
    }

    boolean redoable() {
        return this.firstPrevious >= 1;
    }

}