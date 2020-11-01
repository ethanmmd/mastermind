package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.models.Color;
import ethanmmd.mastermind.models.Combination;
import ethanmmd.mastermind.models.Error;
import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.mastermind.views.MessageView;
import ethanmmd.utils.WithConsoleView;

class ProposedCombinationView extends WithConsoleView {

    private final ProposedCombination proposedCombination;

    ProposedCombinationView(ProposedCombination proposedCombination) {
        this.proposedCombination = proposedCombination;
    }

    void write() {
        for (Color color : this.proposedCombination.getColors()) {
            new ColorView(color).write();
        }
    }

    void read() {
        Error error;
        do {
            error = null;
            MessageView.PROPOSED_COMBINATION.write();
            String characters = this.console.readString();
            if (characters.length() > Combination.getWidth()) {
                error = Error.WRONG_LENGTH;
            } else {
                for (int i = 0; i < characters.length(); i++) {
                    Color color = ColorView.getInstance(characters.charAt(i));
                    if (color == null) {
                        error = Error.WRONG_CHARACTERS;
                    } else {
                        if (this.proposedCombination.getColors().contains(color)) {
                            error = Error.DUPLICATED;
                        } else {
                            this.proposedCombination.getColors().add(color);
                        }
                    }
                }
            }
            if (error != null) {
                new ErrorView(error).writeln();
                this.proposedCombination.getColors().clear();
            }
        } while (error != null);
    }
}
