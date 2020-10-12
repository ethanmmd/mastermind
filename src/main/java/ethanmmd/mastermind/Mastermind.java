package ethanmmd.mastermind;

public class Mastermind {

    private Board board;

    public void startGame(){
        do {
            this.playGame();
        }while (this.playAgain());

    }

    public void playGame(){
        System.out.println(GameInfo.TITLE.toString());
        System.out.println(GameInfo.SECRET_CODE_MESSAGE);
        this.board = new Board(new Turn());
        this.board.write();
        do {
            ProposedCombination proposedCombination = new ProposedCombination();
            proposedCombination.readInput();
            this.board.write();
            this.board.addProposedCombination(proposedCombination);

        } while (this.board.isCodeBroken());

        ////!this.board.isTicTacToe(this.turn.getToken()));
        //        //this.turn.writeWinner();



    }

    public boolean playAgain(){
        return false;

    }

    public static void main(String[] args) {
        new Mastermind().startGame();
    }


}
