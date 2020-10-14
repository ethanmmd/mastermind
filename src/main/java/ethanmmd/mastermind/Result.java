package ethanmmd.mastermind;

public class Result {

    public static final int COMBINATION_LENGTH = 4;
    private int whitePegs = 0;
    private int blackPegs = 0;

    Result(int blackPegs, int whitePegs) {
        this.blackPegs = blackPegs;
        this.whitePegs = whitePegs;
    }

    boolean isDecrypted() {
        return this.blackPegs == Result.COMBINATION_LENGTH;
    }


    public int getBlackPegs() {
        return blackPegs;
    }

    public void setBlackPegs(int blackPegs) {
        this.blackPegs = blackPegs;
    }

    public int getWhitePegs() {
        return whitePegs;
    }

    public void setWhitePegs(int whitePegs) {
        this.whitePegs = whitePegs;
    }

}
