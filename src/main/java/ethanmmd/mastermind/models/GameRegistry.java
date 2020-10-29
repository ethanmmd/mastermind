package ethanmmd.mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class GameRegistry {

    private List<GameMemento> gameMementoList;
    private final Game game;
    private int firstPrevious;

    public GameRegistry(Game game) {
        this.game = game;
        this.reset();
    }

    void reset() {
        this.gameMementoList = new ArrayList<>();
        this.firstPrevious = 0;
    }

    void registry() {
        for (int i = 0; i < this.firstPrevious; i++) {
            this.gameMementoList.remove(0);
        }
        this.firstPrevious = 0;
        this.gameMementoList.add(this.firstPrevious, this.game.createGameMemento());
    }

    void undo() {
        if (this.gameMementoList.size() > 0)
            this.firstPrevious++;
        this.game.set(this.gameMementoList.get(this.firstPrevious));
    }

    void redo() {
        this.firstPrevious--;
        this.game.set(this.gameMementoList.get(this.firstPrevious));
    }

    boolean undoable() {
        return this.firstPrevious < this.gameMementoList.size() - 1;

    }

    boolean redoable() {
        return this.firstPrevious >= 1;

    }
}
