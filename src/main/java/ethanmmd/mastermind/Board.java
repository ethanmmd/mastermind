package ethanmmd.mastermind;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int MAXIMUM_TRIES = 10;
    private SecretCombination secretCombination;
    private List<ProposedCombination> proposedCombinationList;
    private int decryptionAttempts;

    Board() {
        this.secretCombination = new SecretCombination();
        this.proposedCombinationList = new ArrayList<>();
        this.decryptionAttempts = 0;
    }

    public void write() {
        GameInfo.DECRYPTION_ATTEMPT.writeln(this.decryptionAttempts);
        for (int i = 0; i < this.decryptionAttempts; i++) {
            this.proposedCombinationList.get(i).write();

        }
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        proposedCombination.setResult(this.secretCombination.getResult(proposedCombination));
        this.proposedCombinationList.add(proposedCombination);
        this.decryptionAttempts++;
    }

    public boolean isCodeBroken(ProposedCombination proposedCombination) {
        return isDecrypted(proposedCombination) || noMoreAttempts();
    }

    public boolean isDecrypted(ProposedCombination proposedCombination) {
        return proposedCombination.getResult().isDecrypted();
    }

    private boolean noMoreAttempts() {
        return proposedCombinationList.size() == MAXIMUM_TRIES;
    }

}
