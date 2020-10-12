package ethanmmd.mastermind;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.*;

public class Board {


    private Turn turn;

    public Board(Turn turn) {
        this.turn = turn;
    }


    public void write(){
        this.turn.play();
    }

    public boolean isCodeBroken(){
        return false;


    }

    public void addProposedCombination(ProposedCombination proposedCombination){
        this.turn.addCombination(proposedCombination);
    }


}
