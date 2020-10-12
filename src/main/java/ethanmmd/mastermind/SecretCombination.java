package ethanmmd.mastermind;

import java.util.Collections;
import java.util.List;

public class SecretCombination extends Combination {


    public SecretCombination() {
        super();
        List<String> allowedColors = Color.getAllowedColors();
        for (int i = 0; i < 5; i++) {
            this.colorMix.add(allowedColors.get(i));
            Collections.shuffle(this.colorMix);
        }


    }

    Result getResult(ProposedCombination proposedCombination) {
        int blacks = 0;
        for (int i = 0; i < this.colorMix.size(); i++) {
            if (proposedCombination.contains(this.colorMix.get(i), i)) {
                blacks++;
            }
        }
        int whites = 0;
        for (String color : this.colorMix) {
            if (proposedCombination.contains(color)) {
                whites++;
            }
        }
        return new Result(blacks, whites - blacks);
    }


}
