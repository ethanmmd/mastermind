package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Game;
import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.models.Result;

public class Logic implements ProposalLogic, ResumeLogic {

    protected Game game;
    protected ProposalController proposalController;
    protected ResumeController resumeController;

    public Logic() {
        this.game = new Game();
        this.proposalController = new ProposalController(this.game);
        this.resumeController = new ResumeController(this.game);
    }

    @Override
    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.proposalController.addProposedCombination(proposedCombination);
    }

    @Override
    public int getAttempts() {
        return this.proposalController.getAttempts();
    }

    @Override
    public ProposedCombination getProposedCombination(int position) {
        return this.proposalController.getProposedCombination(position);
    }

    @Override
    public Result getResult(int position) {
        return this.proposalController.getResult(position);
    }

    @Override
    public boolean isLooser() {
        return this.proposalController.isLooser();
    }

    @Override
    public boolean isWinner() {
        return this.proposalController.isWinner();
    }

    @Override
    public void clear() {
        this.resumeController.clear();
    }
}
