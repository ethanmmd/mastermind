package ethanmmd.mastermind;

import java.util.ArrayList;
import java.util.List;

public abstract class Combination {

    protected List<String> colorMix;

    protected Combination(){
        this.colorMix = new ArrayList<String>();
    }
}
