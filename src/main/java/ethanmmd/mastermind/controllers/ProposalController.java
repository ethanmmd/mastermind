package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Error;
import ethanmmd.mastermind.models.*;
import ethanmmd.mastermind.views.MessageView;
import ethanmmd.mastermind.views.console.*;

import static ethanmmd.mastermind.models.Error.*;
import static ethanmmd.mastermind.models.SecretCombination.*;
import static java.util.Objects.nonNull;

public class ProposalController extends Controller {

    public ProposalController(Game game, Status status) {
        super(game, status);
    }

    @Override
    public void control() {
        ProposalView proposalView = new ProposalView();
        ProposedCombination proposedCombination = new ProposedCombination();
        ProposedCombinationView proposedCombinationView = new ProposedCombinationView();
        Error error;
        do {
            error = readAndValidateProposedCombination(proposedCombinationView, proposedCombination);
            if (nonNull(error)) {
                new ErrorView().show(error.ordinal());
                proposedCombination.getColors().clear();
            }
        } while (nonNull(error));

        this.addProposedCombination(proposedCombination);
        proposalView.show(this.getAttempts());
        new SecretCombinationView().show(getWidth());
        for (int i = 0; i < this.getAttempts(); i++) {
            for (Color color : this.getProposedCombination(i).getColors()) {
                new ColorView().show(color);
            }
            new ResultView().show(this.getResult(i));
        }
        if (this.isWinner()) {
            MessageView.WINNER.writeln();
            this.next();
        } else if (this.isLooser()) {
            MessageView.LOOSER.writeln();
            this.next();
        }
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.game.addProposedCombination(proposedCombination);
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

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    private Error readAndValidateProposedCombination(ProposedCombinationView proposedCombinationView, ProposedCombination proposedCombination) {
        Error error;
        error = null;
        String characters = proposedCombinationView.show();
        if (characters.length() > Combination.getWidth()) {
            error = WRONG_LENGTH;
        } else {
            for (int i = 0; i < characters.length(); i++) {
                Integer colorPosition = ColorView.getInstance(characters.charAt(i));
                if (colorPosition == null) {
                    error = WRONG_CHARACTERS;
                } else {
                    if (proposedCombination.getColors().contains(Color.values()[colorPosition])) {
                        error = DUPLICATED;
                    } else {
                        proposedCombination.getColors().add(Color.values()[colorPosition]);
                    }
                }
            }
        }
        return error;
    }

}
