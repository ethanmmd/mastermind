package ethanmmd.mastermind;

import java.util.Collections;
import java.util.List;

public class SecretCombination extends Combination {


    public SecretCombination() {
        super();
        List<Color> allowedColors = Color.getAllowedColors();
        for (int i = 0; i<COMBINATION_LENGHT; i++) {
            this.colors.add(allowedColors.get(i));
            Collections.shuffle(this.colors);
        }


    }

    Result getResult(ProposedCombination proposedCombination) {
        int blacks = 0;
        for (int i = 0; i < this.colors.size(); i++) {
            if (proposedCombination.contains(this.colors.get(i), i)) {
                blacks++;
            }
        }
        int whites = 0;
        for (Color color : this.colors) {
            if (proposedCombination.contains(color)) {
                whites++;
            }
        }
        return new Result(blacks, whites - blacks);
    }


}
