package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.models.Result;

public interface ProposalLogic {

    void addProposedCombination(ProposedCombination proposedCombination);

    int getAttempts();

    ProposedCombination getProposedCombination(int position);

    Result getResult(int position);

    boolean isLooser();

    boolean isWinner();
}
