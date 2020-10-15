package ethanmmd.mastermind;

import ethanmmd.utils.YesNoDialog;

public class Mastermind {

    private static final String LOSE = "lose";
    private static final String WIN = "win";
    private Board board;

    private void startGame() {
        String result;
        do {
            result = this.playGame();
        } while (this.playAgain(result));

    }

    private String playGame() {
        GameInfo.TITLE.writeln();
        GameInfo.SECRET_CODE_MESSAGE.writeln();
        this.board = new Board();
        this.board.write();
        ProposedCombination proposedCombination;

        do {
            proposedCombination = new ProposedCombination();
            proposedCombination.readUserInput();
            this.board.addProposedCombination(proposedCombination);
            this.board.write();

        } while (!this.board.isCodeBroken(proposedCombination));

        String gameResult = LOSE;
        GameInfo resultMessage = GameInfo.LOOSER_INFO;

        if (this.board.isDecrypted(proposedCombination)) {
            resultMessage = GameInfo.WIN_MESSAGE;
            gameResult = WIN;
        }

        resultMessage.writeln();
        return gameResult;
    }

    private boolean playAgain(String result) {
        return new YesNoDialog().read(String.format(GameInfo.RESUME.getMessage(), result));

    }

    public static void main(String[] args) {
        new Mastermind().startGame();
    }


}
