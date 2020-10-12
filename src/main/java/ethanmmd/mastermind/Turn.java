package ethanmmd.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sun.deploy.perf.DeployPerfUtil.write;

public class Turn {

    private SecretCombination secretCombination;
    private List<ProposedCombination> proposedCombinationList;
    private Result[] results;
    private int decryptionAttempts;

    public static final int COMBINATION_SIZE = 4;

    Turn(){
        this.secretCombination = new SecretCombination();
        this.proposedCombinationList = new ArrayList<ProposedCombination>();
        this.decryptionAttempts = 0;
    }

    public void play(){
        for (int i = 0; i < this.decryptionAttempts; i++) {
            System.out.println(this.proposedCombinationList.get(i));
        }
    }

    public void addCombination(ProposedCombination proposedCombination){
        this.proposedCombinationList.add(proposedCombination);
        this.results[this.decryptionAttempts] = this.secretCombination.getResult(proposedCombination);
        this.decryptionAttempts++;
    }
}
