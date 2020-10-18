package ethanmmd.mastermind.models;

public class Status {

    private GameStatus gameStatus;

    public Status() {
        this.reset();
    }

    public void reset(){
        this.gameStatus = GameStatus.STARTED;
    }

    public void next(){
        this.gameStatus = GameStatus.values()[this.gameStatus.ordinal() + 1];
    }

    public GameStatus getGameStatus(){
        return this.gameStatus;
    }
}
