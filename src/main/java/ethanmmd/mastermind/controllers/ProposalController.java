package ethanmmd.mastermind.controllers;

import ethanmmd.mastermind.models.Error;
import ethanmmd.mastermind.models.*;
import ethanmmd.mastermind.views.*;

import static ethanmmd.mastermind.models.Error.*;
import static ethanmmd.mastermind.models.SecretCombination.getWidth;
import static ethanmmd.mastermind.views.ColorView.getInstance;
import static java.util.Objects.nonNull;

public class ProposalController extends Controller {

    public ProposalController(Game game, Status status) {
        super(game, status);
    }

    @Override
    public void control() {
        ProposalView proposalView = new ProposalView();
        SecretCombinationView secretCombinationView = new SecretCombinationView();
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
        secretCombinationView.show(getWidth());
        ColorView colorView = new ColorView();

        for (int i = 0; i < this.getAttempts(); i++) {
            for (Color color : this.getProposedCombination(i).getColors()) {
                colorView.show(color);
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

    private Error readAndValidateProposedCombination(ProposedCombinationView proposedCombinationView, ProposedCombination proposedCombination) {
        Error error;
        error = null;
        String characters = proposedCombinationView.show();
        if (characters.length() > getWidth()) {
            error = WRONG_LENGTH;
        } else {
            for (int i = 0; i < characters.length(); i++) {
                Integer colorPosition = getInstance(characters.charAt(i));
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

    private void addProposedCombination(ProposedCombination proposedCombination) {
        this.game.addProposedCombination(proposedCombination);
    }

    private int getAttempts() {
        return this.game.getAttempts();
    }

    private ProposedCombination getProposedCombination(int position) {
        return this.game.getProposedCombination(position);
    }

    private Result getResult(int position) {
        return this.game.getResult(position);
    }

    private boolean isWinner() {
        return this.game.isWinner();
    }

    private boolean isLooser() {
        return this.game.isLooser();
    }

}
